package com.oms.db.seed;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oms.bean.Cost;

public class Seed {
//	private ArrayList<Media> medias;
	
	private ArrayList<Cost> cost;
	
	private static Seed singleton = new Seed();
	
	private Seed() {
		start();
	}
	
	public static Seed singleton() {
		return singleton;
	}
	
	private void start() {
		cost = new ArrayList<Cost>();
		cost.addAll(generateDataFromFile( new File(getClass().getResource("./cost.json").getPath()).toString()));
		
	}
	
	private ArrayList<? extends Cost> generateDataFromFile(String filePath){
		ArrayList<? extends Cost> res = new ArrayList<Cost>();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<Cost>>() { });
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}
		
		return res;
	}
	
	public ArrayList<Cost> getCost() {
		return cost;
	}


	public static void main(String[] args) {
		Seed seed = new Seed();
		seed.start();
	}
}
