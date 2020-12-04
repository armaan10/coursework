package lab4demo;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
public class GenreCount {
	public static void main(String [] args) throws Exception
	{
	Configuration c=new Configuration();
	String[] files=new GenericOptionsParser(c,args).getRemainingArgs();
	Path input=new Path(files[0]);
	Path output=new Path(files[1]);
	Job j=new Job(c,"genrecount");
	j.setJarByClass(GenreCount.class);
	j.setMapperClass(MapForGenreCount.class);
	j.setReducerClass(ReduceForGenreCount.class);
	j.setOutputKeyClass(Text.class);
	j.setOutputValueClass(Text.class);
	FileInputFormat.addInputPath(j, input);
	FileOutputFormat.setOutputPath(j, output);
	System.exit(j.waitForCompletion(true)?0:1);
	}
	
	public static class MapForGenreCount extends Mapper<LongWritable, Text,
	Text, Text>{
		
		public void map(LongWritable key, Text value, Context con) throws
		IOException, InterruptedException
		{
		String line = value.toString();
		String[] words=line.split(",");
		String[] genres=words[2].split("\\|");
		Text outputKey = new Text(words[1].toUpperCase().trim());
		for (String genre:genres)
		{
			Text outputValue=new Text(genre.toUpperCase().trim());
			con.write(outputKey, outputValue);
		}
		
		//IntWritable outputValue = new IntWritable(1);
		
		//con.write(outputKey, outputValue);
		}
		}
		public static class ReduceForGenreCount extends Reducer<Text,
		Text, Text, IntWritable>
		{
		public void reduce(Text word, Iterable<Text> values, Context
		con) throws IOException, InterruptedException
		{
		int count = 0;
		for(Text value : values)
		{
		count ++;
		}
		if(count>2)
		{con.write(word, new IntWritable(count));}
		}
		}
	
		
	
		}

