package lab4demo;
import java.io.IOException;

import lab4demo.GenreCount.MapForGenreCount;
import lab4demo.GenreCount.ReduceForGenreCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
public class LabEval {

	public static void main(String [] args) throws Exception
	{
	Configuration c=new Configuration();
	String[] files=new GenericOptionsParser(c,args).getRemainingArgs();
	Path input=new Path(files[0]);
	Path output=new Path(files[1]);
	Job j=new Job(c,"genrecount");
	//Set Map and reducer class along with output datatypes

	j.setJarByClass(GenreCount.class);
	j.setMapperClass(MapForLabCount.class);
	j.setReducerClass(ReduceForLabCount.class);
	j.setOutputKeyClass(Text.class);//change
	j.setOutputValueClass(IntWritable.class);//change
	FileInputFormat.addInputPath(j, input);
	FileOutputFormat.setOutputPath(j, output);
	System.exit(j.waitForCompletion(true)?0:1);
	}
	//map function key value pairs datatype<keyin,valuein,keyout,valueout>

		public static class MapForLabCount extends Mapper<LongWritable, Text,
		Text, IntWritable>{
			
			public void map(LongWritable key, Text value, Context con) throws
			IOException, InterruptedException
			{//convert doc/tuple to string
			String line = value.toString();
			//split columns
			String[] words=line.split(",");
			int radio=Integer.parseInt(words[3]);
			int skip=Integer.parseInt(words[4]);
			//set o/p key to movie name
			Text outputKey = new Text(words[1].trim());
			
			if(skip==1 && radio==1)
			{	IntWritable outputValue = new IntWritable(1);
			con.write(outputKey, outputValue);
			}
			//IntWritable outputValue = new IntWritable(1);
			
			//con.write(outputKey, outputValue);
			}
			}
		
		
		public static class ReduceForLabCount extends Reducer<Text,
		IntWritable, Text, IntWritable>
		{
		public void reduce(Text word, Iterable<IntWritable> values, Context
		con) throws IOException, InterruptedException
		{
		//sum over all values present in a key's value list
		int sum = 0;
		for(IntWritable value : values)
		{
		sum ++;
		}
		//final o/p is number of times key occurs
		con.write(word, new IntWritable(sum));
		}
		}

}
