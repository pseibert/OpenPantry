
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class BenchAreaML {
	public static void main(String[] args) {

		try {
			FileReader fin = new FileReader("ml 02 25 wo 0.txt");


			BufferedReader b = new BufferedReader(fin);
			FileWriter fout = new FileWriter("ml bench 02 25.txt");
			BufferedWriter bout= new BufferedWriter(fout);
			//ArrayList <Point3d> points = new ArrayList<Point3d>();
			String currentLine= b.readLine();



			while (currentLine != null ) {	
				String[] words=currentLine.split("\t");

				for(int i=0;i<words.length-2;i++){
					double c1= Double.parseDouble(words[0]);
				//	double c2= Double.parseDouble(words[1]);
					double c3= Double.parseDouble(words[2]);

					//Point3d p1= new Point3d(c1,c2,c3);
					//Point3d p0=new Point3d(0.0,0.0,0.0);

// find a way to erasethe noise from the boundaries of the kinect range
					if( Math.abs(c3) > 4.2 & c1>-0.5 & c1<0.5){
						bout.write(words[i]+"\t");
						System.out.println("the distance is more than 40");	
						
						if (i == 2){
							bout.write(words[3] +"\t" + words[4] + "\n");
						}
					}

					

				}




				currentLine= b.readLine();


			}


			b.close();
			bout.close();
			System.out.println("Done I am so happy");

		}


		catch (FileNotFoundException ef) {
			System.out.println("File not found");}
		catch (IOException ei) {
			System.out.println("IO Exception"); }
	}
}