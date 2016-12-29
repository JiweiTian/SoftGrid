/* Copyright (C) 2016 Advanced Digital Science Centre

        * This file is part of Soft-Grid.
        * For more information visit https://www.illinois.adsc.com.sg/cybersage/
        *
        * Soft-Grid is free software: you can redistribute it and/or modify
        * it under the terms of the GNU General Public License as published by
        * the Free Software Foundation, either version 3 of the License, or
        * (at your option) any later version.
        *
        * Soft-Grid is distributed in the hope that it will be useful,
        * but WITHOUT ANY WARRANTY; without even the implied warranty of
        * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        * GNU General Public License for more details.
        *
        * You should have received a copy of the GNU General Public License
        * along with Soft-Grid.  If not, see <http://www.gnu.org/licenses/>.

        * @author Prageeth Mahendra Gunathilaka
*/
package it.illinois.adsc.ema.tools;

import java.io.*;

public class ComparisonCSVGenerator {

	private static final String BASE_PATH="C:\\Users\\daisuke.m\\Desktop\\37-bus_experiments\\";
	private static final String PATH_TO_SUMMARY = "\\result\\summary\\"; 
	
	private static String[] DIRS= {"random_attack_0_mitigation_5sec_1sec", "random_attack_0_mitigation_5sec_2.5sec","random_attack_0_mitigation_5sec_4sec","random_attack_0_no_mitigation"}; 
	
	public static void main(String args[]) throws IOException{
	
		String outDirName = "";
		for(int i=0; i < DIRS.length; i++){
			outDirName += (DIRS[i]);
			if(i < DIRS.length-1) outDirName+= "--";
		}
		//System.out.println(outDirName);
		
		new File(BASE_PATH + outDirName).mkdir();
		
		File files[] = new File(BASE_PATH + DIRS[0]+ PATH_TO_SUMMARY).listFiles();
		for(File file : files){
			System.out.println(file.getName());
			PrintWriter pw = new PrintWriter(BASE_PATH + outDirName + "\\" + file.getName());
			pw.println(",10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100,");
			for(int i=0; i < DIRS.length; i++){
				String averageCSV = DIRS[i] + "," + createAverageCSV(new File(BASE_PATH + DIRS[i] + PATH_TO_SUMMARY + file.getName()));
				System.out.println(averageCSV);
				pw.println(averageCSV);
			}			
			
			pw.flush();
			pw.close();
			
		}
	}
	
	private static String createAverageCSV(File file) throws IOException{
		
		String out ="";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;
		
		while((line=br.readLine())!= null){

			//skip empty line
			if(line.trim().length()==0)continue;
			
			String[] tokens = line.split(",");
			//System.out.println(tokens.length);
			double sum = 0d;
			for(int i=1; i < tokens.length; i++){
				if(tokens[i].trim().length() == 0)continue;
				sum += Double.parseDouble(tokens[i]);
			}
			double average = sum / (tokens.length-1);
			out += average + ",";
		}
		br.close();

		//System.out.println(out);
		return out;
		
	}
	
	
}
