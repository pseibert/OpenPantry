
import java.io.*;

public class EraseNoiseMLL {
	public static void main(String[] args) {


		try {
			FileReader fin = new FileReader("ml 02 25 u5.txt");
			BufferedReader b = new BufferedReader(fin);
			FileWriter fout = new FileWriter("ml 02 25 u5 wo noise.txt"); //"k140 day_5_10.txt");
			BufferedWriter bout= new BufferedWriter(fout);
			//String preSec= "00";
			String currentLine= b.readLine();
			String fakex= "xxxxxx";
			String fakey= "xxxxxx";
			String fakez= "xxxxxx";

			while (currentLine != null ) {	
				String[] words=currentLine.split("\t");

				//double x = Double.parseDouble(words[0]);
				//double y = Double.parseDouble(words[2]);


				//if(	Math.abs(y)/Math.abs(x) >= 2.09 && Math.abs(y)<4300.0 ){

					if( !fakex.equals(words[0]) &&!fakey.equals(words[1])&&!fakez.equals(words[2]) ){
						bout.write(words[0]+ "\t" + words[1]+ "\t" +words[2]+ "\t" + 
								words[3]+ "\t" + words[4]+"\n");
						fakex=words[0];
						fakey=words[1];
						fakez=words[2];

					//}

				}

				currentLine= b.readLine();

			}

			b.close();
			bout.close();
			System.out.println("Done noise");
		}


		catch (FileNotFoundException ef) {
			System.out.println("File not found");}
		catch (IOException ei) {
			System.out.println("IO Exception"); }
	}
}