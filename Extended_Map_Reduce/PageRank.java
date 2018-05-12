import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;

public class PageRank {

  public static void main(String[] args) throws Exception {
      if (args.length != 4) {
            System.err.println("Usage: PageRank <input path> <temp path> <temp path> <output path>");
            System.exit(-1);
              }
                for(int i=0;i<3;i++)
                {
                 Job job = new Job();
                 job.setJarByClass(PageRank.class);
                 job.setJobName("PageRank");

                 FileInputFormat.addInputPath(job, new Path(args[i]));
                 FileOutputFormat.setOutputPath(job, new Path(args[i+1]));

                 job.setMapperClass(PageMap.class);
                 job.setReducerClass(PageReduce.class);

                 job.setOutputKeyClass(Text.class);
                 job.setOutputValueClass(Text.class);

	         job.waitForCompletion(true);
                }
                System.exit(0);
                  }
                     }
