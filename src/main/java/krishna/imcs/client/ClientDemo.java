package krishna.imcs.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import krishna.imcs.pojo.DeptBonus;
import krishna.imcs.service.DeptBonusService;
import krishna.imcs.service.EmployeeBonusService;

public class ClientDemo {
	
	DeptBonusService deptservice=new DeptBonusService();
	EmployeeBonusService empbonusservice= new EmployeeBonusService();
	final String filename="E:/dir/employeedata.txt";
	public void readDeptBonus() throws Exception {

		try (BufferedReader br=new BufferedReader(new FileReader(new File(filename)))){

			List<DeptBonus> list=new ArrayList<>();
			String line = null;
			boolean keepReading = true;

			int index = 0;
			while (keepReading) {
				line = br.readLine();

				if (line == null || line.equals("")) {
					break;
				}
				if (index != 0) {
					DeptBonus deptbonus = parseLine(line);
					list.add(deptbonus);

				}

				index++;
			}
			
			deptservice.loadAllDeptBonus(list);
		}
	}
	private DeptBonus parseLine(String line) {
		String[] tokens = line.split("\\s+");
		System.out.println(tokens[0]);
		DeptBonus deptbonus = new DeptBonus(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]),Double.parseDouble(tokens[1]));
		return deptbonus;
	}

	public static void main(String[] args) throws Exception {
		
		ClientDemo client=new ClientDemo();
		client.readDeptBonus();
		client.empbonusservice.allocateBonus();
		
	
	}
}


	


