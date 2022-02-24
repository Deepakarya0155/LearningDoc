package overriding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class Test {
	
	
	
	public static void main(String[] args) throws IOException {
		
//		keyList("questions.txt");
		
		
//		List<String> keylist=readFile("key.txt");
//		List<String> data =readFile("questions.txt");
//		List<String> responseData=new ArrayList<String>();
//		keylist.forEach(S->{
//			responseData.add("KEY # "+S);
//			responseData.addAll(data.stream().filter(K->K.toLowerCase().contains(S)).toList());
//		});
//		
//		responseData.add("###########others########");
//		data.forEach(S->{
//			if(!responseData.contains(S)) {
//				responseData.add(S);
//			}
//		});
//		
//		writeToFile(responseData.stream().distinct().toList(),"out.txt");
		
		
		
		List<String> data =readFile("questions.txt");
		Map<Integer,List<String>> mp= data.stream().filter(S->!S.startsWith("KEY") && !S.trim().equals(""))
		.collect(Collectors.groupingBy(S->{
			try {
				return S.split("#").length>1?Integer.parseInt(S.split("#")[1].trim()):1;
			}catch(Exception e) {
				return 1;
			}
		}));
		
		
		List<String> pList=new ArrayList<String>();
		mp.forEach((K,V)->{
			pList.add("P = "+K);
			pList.addAll(V);
		});	
		writeToFile(pList,"Plist.txt");
	}
	
	public static void writeToFile(List<String> ls,String filename) throws IOException {
		BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
		ls.forEach(S->{
			try {
				w.write(S);
				w.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		w.close();
	}
	
	public static void keyList(String filename) throws IOException {
		List<String> data =readFile(filename);
		Set<String> st=new HashSet<String>();
		List<String> responseData=new ArrayList<String>();
		
		
		data.stream().forEach(S->{
			Stream.of(S.split(" "))
			.filter(K->{
				return !(K.matches("[0-9#)\\.q]+")
						
						
						
						);
			})
			.filter(K->K.length()>2)
			.map(String::toLowerCase).distinct().forEach(st::add);
		});
		System.out.println(st.size());
		
		writeToFile(st.stream().sorted().toList(), "key.txt");
	}
	
	public static List<String> readFile(String filename) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		List<String> data=reader.lines().toList();
		reader.close();
		return data;
	}
	//1521
}
