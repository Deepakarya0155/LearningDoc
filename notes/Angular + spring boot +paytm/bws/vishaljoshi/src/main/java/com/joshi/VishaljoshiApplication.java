package com.joshi;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import com.opencsv.CSVReader;

@SpringBootApplication
public class VishaljoshiApplication implements CommandLineRunner{

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(VishaljoshiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CSVReader csvReader=new CSVReader(new FileReader("data.csv"));
		List<DataDO> ls=csvReader.readAll().stream().skip(1).map(S->{
			
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy h:ss");
			LocalDate date=LocalDate.parse(S[0], formatter);
			DataDO datado=new DataDO(date,Long.parseLong(S[1]),
					Long.parseLong(S[2]),
					Long.parseLong(S[3]),
					Long.parseLong(S[4]),
					Long.parseLong(S[5]),
					Long.parseLong(S[6]),
					Long.parseLong(S[7]));
			return datado;
			
		}).toList();
				

		System.out.println(process(ls,2));
		
		
		
		
	}
	
	public Long process(List<DataDO> ls,int step) {
		Long sum=0l;
		List<LocalDate> uniqListOfDate=ls.stream().map(DataDO::getDate).sorted(Comparator.reverseOrder()).distinct().toList();
		Map<LocalDate,List<DataDO>> mapdata=ls.stream().collect(Collectors.groupingBy(DataDO::getDate));
		int temp=0;
		for(int i=step;i<=7;i++) {
			if(temp<uniqListOfDate.size()) {
				List<DataDO> subList=mapdata.get(uniqListOfDate.get(temp));
				
				for(DataDO da:subList) {
//					String data=da.getList().stream().skip(i-1).map(S->S+"")
//					.collect(Collectors.joining(",","[","]"));
//					System.out.println(data);
					
					sum+=da.getList().stream().skip(i-1).mapToLong(S->S).sum();
				}
				
				temp++;
			}
		
		}
		
		return sum;
	}
	
	


}
