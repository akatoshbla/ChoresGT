import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Child {
	private Path filepath;
	private String name;
	private String time;
	private String money;
	
	public Child(String name) {
		this.name = name;
		try {
			filepath = new File("children.dat").toPath();
			List<String> list = Files.readAllLines(filepath);
			
			String[] lines = list.toArray(new String[]{});
			//System.out.println(lines[0]);
			for (String line : lines) {
				if (line.substring(0, line.indexOf(",")).equals(name)) {
					time = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
					money = line.substring(line.lastIndexOf(",") + 1, line.length());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}

	public String getMoney() {
		return money;
	}
	
	protected void setTime(int time) {
		String child;
		int index;
		if (this.name.equals("elijah")) {
			child = "elijah";
			index = 0;
		} else {
			child = "gracie";
			index = 1;
		}
		try {
			List<String> lines = new ArrayList<>(Files.readAllLines(filepath));
			lines.set(index, child + "," + String.valueOf(time) + "," + this.money);
			Files.write(filepath, lines);
			this.time = String.valueOf(time);
			System.out.println(this.time);
			Main app = Main.getSharedApplication();
			app.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void setMoney(Double money) {
		String child;
		int index;
		if (this.name.equals("elijah")) {
			child = "elijah";
			index = 0;
		} else {
			child = "gracie";
			index = 1;
		}
		try {
			List<String> lines = new ArrayList<>(Files.readAllLines(filepath));
			lines.set(index, child + "," + this.time + "," + String.format("%1$.2f", money));
			Files.write(filepath, lines);
			this.money = String.format("%1$.2f", money);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
