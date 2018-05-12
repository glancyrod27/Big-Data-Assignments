import java.io.IOException;
import java.lang.*;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class PageMap extends Mapper<LongWritable, Text, Text, Text>
{

        @Override
      public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
      {

          String line = value.toString();
          String str1 = new String();
        double pr = 0.0,k=0.0;
        str1="";
         // StringTokenizer tokenizer = new StringTokenizer(line);
        for (int i=0; i<line.length();i++)
        {
                if (line.charAt(i) == '0')
                {
                        k=Double.parseDouble(line.substring(i));
                        break;
                }
                else
                {
                        if (line.charAt(i)>=65 && line.charAt(i)<=90)
			 {
                        str1=str1+line.charAt(i);
                        }
        }       }
        pr=k/((str1.length())-1);
        for (int i=1;i<str1.length();i++)
        {
                context.write(new Text(""+str1.charAt(i)), new Text(""+Double.toString(pr)));
        }
        context.write(new Text(""+str1.charAt(0)), new Text(""+str1.substring(1)));
    }
}
