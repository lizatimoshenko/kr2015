import java.io.File;
	import java.io.IOException;
	import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Set;

public class WaterBalance {
	

	
	    private HashMap<String,ArrayList<Liquid>> myWater;
	    private RandomAccessFile waterDiary;

	    WaterBalance() throws IOException {
	        waterDiary= new RandomAccessFile(new File("WaterDiary.dat"), "rw");
	        myWater=getBeverage();
	    }

	   
	    public void addToFile(String date,String beverage, Double ml)
	            throws IOException {
	        waterDiary.seek(waterDiary.length());
	        waterDiary.writeUTF(date);
	        waterDiary.writeUTF(beverage);
	        waterDiary.writeDouble(ml);
	       
	    }
	//////////

	    public HashMap<String,ArrayList<Liquid>> getBeverage() throws IOException {
	        waterDiary.seek(0);
	        HashMap<String,ArrayList<Liquid>> amount = new HashMap<String,ArrayList<Liquid>>();
	        int b = waterDiary.read();
	        if (b == -1) {
	            return amount;
	        }
	        waterDiary.seek(waterDiary.getFilePointer() - 1);
	        while (b != -1) {
	            String n =waterDiary.readUTF();
	            String ip =waterDiary.readUTF();
	            double ml=waterDiary.readDouble();
	            if(amount.containsKey(n)){
	            	amount.get(n).add(new Liquid(ml,ip));
	            }else{
	            	ArrayList<Liquid> a = new ArrayList<Liquid>();
	            	a.add(new Liquid(ml,ip));
	            	amount.put(n, a);
	            }
	            b = waterDiary.read();
	            waterDiary.seek(waterDiary.getFilePointer() - 1);
	        }
	        return amount;

	    }

	    public void rewriteFile(HashMap<String,ArrayList<Liquid>> hm)
	            throws IOException {
	    	waterDiary.setLength(0);
	        Set<String> n=hm.keySet();
	        Iterator<String> itr = n.iterator();
	        String s;
	        while (itr.hasNext()){
	            s=itr.next();
	            for(int i=0;i<hm.get(s).size();i++){
	            waterDiary.writeUTF(s);
	            waterDiary.writeUTF(hm.get(s).get(i).getName());
	            waterDiary.writeDouble(hm.get(s).get(i).getKol());
	            }
	        }

	    }

	    public HashMap<String,ArrayList<Liquid>> getMyWater(){
	        return myWater;
	    }

		}

class Liquid{
	private double kol;
	private String name;
	 
	Liquid(double k,String n){
		kol=k;
		name=n;
	}

	public double getKol() {
		return kol;
	}

	public String getName() {
		return name;
	}
}


