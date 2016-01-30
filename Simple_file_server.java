import java.net.*;
import java.io.*;
import java.util.*;
class Server extends Thread{
	static ServerSocket ss;	
	static Socket socket;
	public void run(){		
		try{
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("Please enter the file name");
			
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			String fileN=dis.readUTF();
			System.out.println(fileN);
			try{
				BufferedReader br=new BufferedReader(new FileReader(fileN));	
				StringBuilder sb=new StringBuilder();
				String line="";
				line= br.readLine();
			while(line!=null){
				sb.append(line);
				sb.append("\n");
				//System.out.println(line);
				line= br.readLine();
				//dos.writeUTF(line);
			}
			dos.writeUTF(sb.toString());
			}	catch(FileNotFoundException e){
				dos.writeUTF("File is not found");
			}		
			dos.close();
			
			
			
		}
		catch(Exception e){
			
		}	
	}
	public static void main(String ... S) throws Exception
	{
		ss=new ServerSocket(3030);
		while(true){	
			socket=ss.accept();			
			Thread t=new Thread(new Server());
			t.start();
		}
		
		
	}	
}

class Client4{
	public static void main(String ... S)throws Exception
	{
			Scanner scan=new Scanner(System.in);
			String fileName; 
			Socket sn=new Socket("localhost",3030);
			DataInputStream dis=new DataInputStream(sn.getInputStream());
			System.out.println(dis.readUTF());
			
			DataOutputStream dos=new DataOutputStream(sn.getOutputStream());
			fileName=scan.nextLine();
			dos.writeUTF(fileName);
			
			
			//System.out.println(dis.readUTF());

			//FileOutputStream fis =new FileOutputStream(new File("Clientfile.txt"));
			String file=dis.readUTF();
			//int k=file.length();
			System.out.println(file);
			//for(int i=0;i<file.length();i++){
			//	fis.write((byte)(file.charAt(i)));
			//}
			dos.close();	
	}
}

class Client2{
	public static void main(String ... S)throws Exception
	{
			Scanner scan=new Scanner(System.in);
			String fileName; 
			Socket sn=new Socket("localhost",3030);
			DataInputStream dis=new DataInputStream(sn.getInputStream());
			System.out.println(dis.readUTF());
			
			DataOutputStream dos=new DataOutputStream(sn.getOutputStream());
			fileName=scan.nextLine();
			dos.writeUTF(fileName);
			
			
			//System.out.println(dis.readUTF());

			//FileOutputStream fis =new FileOutputStream(new File("Clientfile.txt"));
			String file=dis.readUTF();
			//int k=file.length();
			System.out.println(file);
			//for(int i=0;i<file.length();i++){
			//	fis.write((byte)(file.charAt(i)));
			//}
			dos.close();	
	}
}
class Client1{
	public static void main(String ... S)throws Exception
	{
			Scanner scan=new Scanner(System.in);
			String fileName; 
			Socket sn=new Socket("localhost",3030);
			DataInputStream dis=new DataInputStream(sn.getInputStream());
			System.out.println(dis.readUTF());
			
			DataOutputStream dos=new DataOutputStream(sn.getOutputStream());
			fileName=scan.nextLine();
			dos.writeUTF(fileName);
			
			
			//System.out.println(dis.readUTF());

			//FileOutputStream fis =new FileOutputStream(new File("Clientfile.txt"));
			String file=dis.readUTF();
			//int k=file.length();
			System.out.println(file);
			//for(int i=0;i<file.length();i++){
			//	fis.write((byte)(file.charAt(i)));
			//}
			dos.close();	
	}
}

