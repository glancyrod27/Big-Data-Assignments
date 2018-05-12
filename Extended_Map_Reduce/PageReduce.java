import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapred.*;
import java.lang.*;

public class PageReduce extends Reducer<Text, Text, Text, Text>
{
        @Override
         public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
      {
            double sum=0.0;
                String ans = new String();
            String str1= new String();
                String str2=new String();

 for (Text value : values) {
//      str1=toString(value.get());
        str1=value.toString();
        if(str1.charAt(0)=='0')
        {      sum  = sum + Double.parseDouble(str1.substring(1));

        }
        else
        {
                str2 = str1;
        }
}
ans=""+str2+Double.toString(sum);
context.write(key,new Text(ans));

}
}

