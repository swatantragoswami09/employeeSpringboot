package com.nagarro.readcsv;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import com.nagarro.model.Products;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCSV {

	public List<Products> readCSV() {
		List<Products> list = new LinkedList<Products>();
		try {
			String path = "D:\\Eclipse Projects Workspace\\ProductSearchUsingSpring\\ProductSearchUsingSpring\\CSVFiles";
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			int c=0;
//			System.out.println("this is read CSV");
//			System.out.println(folder.listFiles()[0].getName());
			if (listOfFiles.length > 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						CSVReader reader = new CSVReaderBuilder(new FileReader(path + "\\" + listOfFiles[i].getName()))
								.withSkipLines(1).build();
						String[] data;
						while ((data = reader.readNext()) != null) {
							for (String row : data) {
								Products product = new Products();
								String[] words = row.split("\\|");
								product.setId( words[0]);
//								product.setId( c++);
								product.setName(words[1]);
								product.setColor(words[2]);
								product.setGender_rec(words[3]);
								product.setSize(words[4]);
								product.setPrice(words[5]);
								product.setRating(words[6]);
								product.setAvalability(words[7]);
								
								list.add(product);
							}
//							System.out.println(list);
						}
						reader.close();
					}
				}
				listOfFiles = new File[0];
//			
				}
//			System.out.println(list);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
