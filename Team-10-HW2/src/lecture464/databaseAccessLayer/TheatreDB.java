package lecture464.databaseAccessLayer;

import java.util.ArrayList;
import java.util.HashMap;

import lecture464.model.Theatre;

public class TheatreDB {
	
	public ArrayList<Theatre> getTheatres(){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		HashMap<Integer,Theatre> theatres = db.getTheatres();
		ArrayList<Theatre> output = new ArrayList<Theatre>();
		for(Integer i : theatres.keySet()){
			output.add(theatres.get(i));
			System.out.println(theatres.get(i).getAddress());
		}
		db.closeConnection();
		return output;
	}
}
