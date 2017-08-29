package company.alibaba;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
		while (scanner.hasNextLine()) {
			String[] options = scanner.nextLine().split(";");
			if (options.length < 5) {
				break;
			}
			lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
		}
		scanner.close();

		// wirte your code here
		List<String> result = calculateUnilateral(lineList);

		for (String str : result) {
			System.out.println(str);
		}
	}

	public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
		List<String> result = new ArrayList<String>();
		
		
		List<UnilateralLine> type1 = new ArrayList<>();
		Map<String,List<UnilateralLine>> sCenMap1 = new HashMap<>();
		Map<String,List<UnilateralLine>> eCenMap1 = new HashMap<>();
		
		
		List<UnilateralLine> type2 = new ArrayList<>();
		Map<String,List<UnilateralLine>> sCenMap2 = new HashMap<>();
		Map<String,List<UnilateralLine>> eCenMap2 = new HashMap<>();
		
		for(UnilateralLine line : lineList){
			if(line.tType.equals("9.6m")){
				type1.add(line);
				
				if(sCenMap1.containsKey(line.sCen)){
					sCenMap1.put(line.sCen, new ArrayList<>());
				}
				sCenMap1.get(line.sCen).add(line);
				
				if(sCenMap1.containsKey(line.eCen)){
					sCenMap1.put(line.eCen, new ArrayList<>());
				}
				eCenMap1.get(line.eCen).add(line);
			}else{
				type2.add(line);
				if(sCenMap2.containsKey(line.sCen)){
					sCenMap2.put(line.sCen, new ArrayList<>());
				}
				sCenMap2.get(line.sCen).add(line);
				
				if(sCenMap2.containsKey(line.eCen)){
					sCenMap2.put(line.eCen, new ArrayList<>());
				}
				eCenMap2.get(line.eCen).add(line);
			}
		}
		
		result.addAll(rule1(sCenMap1,eCenMap1));
		result.addAll(rule1(sCenMap2,eCenMap2));
		
		return result;
	}

	private static Collection<String> rule1(Map<String,List<UnilateralLine>> sCenMap1,
			Map<String,List<UnilateralLine>> eCenMap1) {
	
		for(Map.Entry<String, List<UnilateralLine>> e : sCenMap1.entrySet()){
			String key = e.getKey();
			
			List<UnilateralLine> lien1 = e.getValue();
			
			List<UnilateralLine> lien2 = eCenMap1.get(key);
			
			
			if(lien2==null){
				continue;
			}else{
				
				
				// TODO
			}
			
			
			
		}
		
		
		return new ArrayList<>();
	}

	public static class UnilateralLine {
		private String id;
		private String sCen;// 出发分拨
		private String sPro;// 出发省
		private String eCen;// 到达分拨
		private String ePro;// 到达省
		// 9.6m/17.5m
		private String tType;// 车型

		public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
			this.id = id;
			this.sCen = sCen;
			this.sPro = sPro;
			this.eCen = eCen;
			this.ePro = ePro;
			this.tType = tType;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSCen() {
			return sCen;
		}

		public void setSCen(String ePro) {
			this.ePro = ePro;
		}

		public String getSPro() {
			return sPro;
		}

		public void setSPro(String sPro) {
			this.sPro = sPro;
		}

		public String getECen() {
			return eCen;
		}

		public void setECen(String eCen) {
			this.eCen = eCen;
		}

		public String getEPro() {
			return ePro;
		}

		public void setEPro(String ePro) {
			this.ePro = ePro;
		}

		public String getTType() {
			return tType;
		}

		public void setTType(String tType) {
			this.tType = tType;
		}
	}
}
