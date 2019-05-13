package Graph;
import java.util.*;

public class Std {

	 LinkedHashMap<String,LinkedList<String>> adjList;

	 LinkedList<String> clist;

	 LinkedList<String> oplist;

	 LinkedList<String> op;

	 HashMap<String,Integer>visited;

	 Std(){

		 adjList=new LinkedHashMap<>();

		 oplist=new LinkedList<String>();

		 visited=new HashMap<>();

		 op=new LinkedList<>();

	 }

	public void DFS() {

		    String first=oplist.getFirst();

		    

              if(visited.get(first)==0)

              { 

            	  visited.put(first,1);

            	  DFSVisit(first);

            	  op.addFirst(first);

              }   

        }

   public void DFSVisit(String c) {

          LinkedList<String>d=adjList.get(c);

           visited.put(c,1);

          for(String i:d)

          {

          if(visited.get(i)==0)

          {

        	  DFSVisit(i);

        	  

        	     op.addFirst(i);

          }

          

        }

   }

   public  void remove()

   {

	  LinkedHashMap<String,LinkedList<String>>list=(LinkedHashMap<String, LinkedList<String>>)adjList.clone();

	  int flag=0;

	  Set<String>c,d;

	  LinkedList<String> s,temp;

	  while(true) {  

	  c=list.keySet();

	  d=list.keySet();

	  temp=new LinkedList<String>();

	  for(String i:c)

	  {

		  flag=0;

		  for(String j:d)

		  {

			  s=list.get(j);

			  if(s.contains(j))

			  {

				  flag=1;

				  break;

			  }

		  }

		  if(flag==0)

		  {

			  oplist.add(i);

			  temp.add(i);

		  } 

	  } 

	  if(list.size()==temp.size())

	  {

		  break;

	  }

	  } 

	  System.out.println(oplist);

   }

   public static void main(String[] args) {

   Scanner sc=new Scanner(System.in);

   Std g= new Std();

  
  while(true){
   System.out.println("----------------enter your choice--------------------\n");
   System.out.println("1.enter course requisites\n");
   System.out.println("2.Toplogical sorting using DFS\n");
   System.out.println("3.Toplogical sort using Incoming Degree\n");
   //System.out.println("4.Enter student course Details\n");
   System.out.println("4.exit\n");
   int c=sc.nextInt();
   switch(c)
   {
    case 1:   System.out.print("enter no of courses you want to enter\t");

              int n=sc.nextInt();

               sc.nextLine();

               for(int i=1;i<=n;i++)

                {

	          System.out.print("enter course which will be prerequisite of different courses\t");

	          String c1=sc.next();

	           g.adjList.put(c1, new LinkedList<String>());

	           g.visited.put(c1, 0);

	           System.out.print("enter no course which would be requisite of above courses\t");

	           int m=sc.nextInt();

	           sc.nextLine();

	        for(int j=1;j<=m;j++)

	         {

		  System.out.print("enter courses which can be studdied after entered above courses\t");

		  String c2=sc.next();

		   g.visited.put(c2, 0);

		   g.adjList.get(c1).add(c2);

	         }

                }
                break;

   case 2:      System.out.println("Toplogical sorting using DFS\n");
                g.remove();
                break;

   case 3 :      g.DFS();
                 System.out.println("Toplogical sorting using incoming edges\n");
                 System.out.println(g.op);
                 break;

  /* case 4 :      int f=0; 
                 f=g.student_choice();
                 if(f==0){ System.out.println("Not allowed to make course registration\n");}
                 else
                 System.out.println("Allowed to make course registration\n");
                 break;*/

   default:      return ;
    }
  }
}
}
