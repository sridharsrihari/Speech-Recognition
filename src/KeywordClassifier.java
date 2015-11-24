import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Include X
 *Declare X
 *->ID X
 *->Function X
 *Change X
 *->ID X
 *->Arrays X
 *pointer  X
 *struct   X
 *Block  X 
 *Expression ?
 *Control Structures X
 *Hash Map
 *Find
 *Copy
 *Cut
 *Paste
 *Replace
 *Open Editor
 */


public class KeywordClassifier {
	static String [] datatypes={ "int","float","char","double","long"};
	static String prog="";
public static String voiceInclude()
{System.out.println("Include Mode");
 Scanner scan=new Scanner(System.in);
 String s=scan.next();
 String include="";
 while(!s.equalsIgnoreCase("end"))
 {if(s.equalsIgnoreCase("standard"))
 {	 System.out.println("Standard Libraries");
	 include+="#include<stdio.h>\n#include<conio.h>\n#include<math.h>";
	 
 }
 else if(s.equalsIgnoreCase("system"))
 {   System.out.println("System Libraries");
	 include="#include<"+alphabetRecognize()+".h>";
 }
 else if(s.equalsIgnoreCase("library"))
 {   System.out.println("User Defined Libraries");
	 include+="#include \""+alphabetRecognize()+".h\"";
 }
 s=scan.next();}
 System.out.println("Library Recognized: "+include);
return include+"\n";}


public static String alphabetRecognize()
{ System.out.println("Alphabet mode");
Scanner scan=new Scanner(System.in);
String s=scan.next();
String word="";
while(!s.equalsIgnoreCase("end"))
{System.out.println("Alphabet mode");
if(s.equalsIgnoreCase("number"))
{
	word+=numberRecognize("integer");
	s=scan.next();
	continue;
}
else if(s.equalsIgnoreCase("character"))
{
	word+=characterRecognize();
	s=scan.next();
	continue;
}
else if(s.equalsIgnoreCase("delete"))
{   System.out.println(word);
	word=word.substring(0, word.length()-1);
	System.out.println(word);
	s=scan.next();
	continue;
}
else if(s.contains("term"))
{
	word+=";";
	s=scan.next();
	continue;
}
else if(s.equalsIgnoreCase("return"))
{
	word+="\n";
	s=scan.next();
	continue;
}
else if(s.equalsIgnoreCase("space"))
{
	word+=" ";
	s=scan.next();
	continue;
}
switch(s.toLowerCase().charAt(0))
	{
case 'a':
{word+='a';
break;}
case 'b':
{
	word+='b';
	break;
}
case 'c':
{
	word+='c';
	break;
}
case 'd':
{
	word+='d';
	break;
}
case 'e':
{
	word+='e';
	break;
}
case 'f':
{
	word+='f';
	break;
}
case 'g':
{
	word+='g';
	break;
}
case 'h':
{
	word+='h';
	break;
}
case 'i':
{
	word+='i';
	break;
}
case 'j':
{
	word+='j';
	break;
}
case 'k':
{
	word+='k';
	break;
}
case 'l':
{
	word+='l';
	break;
}
case 'm':
{
	word+='m';
	break;
}
case 'n':
{
	word+='n';
	break;
}
case 'o':
{
	word+='o';
	break;
}
case 'p':
{
	word+='p';
	break;
}
case 'q':
{
	word+='q';
	break;
}
case 'r':
{
	word+='r';
	break;
}
case 's':
{
	word+='s';
	break;
}
case 't':
{
	word+='t';
	break;
}
case 'u':
{
	word+='u';
	break;
}
case 'v':
{
	word+='v';
	break;
}
case 'w':
{
	word+='w';
	break;
}
case 'x':
{
	word+='x';
	break;
}
case 'y':
{
	word+='y';
	break;
}
case 'z':
{
	word+='z';
	break;
}
	}
s=scan.next();
}
System.out.println("Word Recognized: "+word);
return word;}
	
public static String numberRecognize(String input)
{System.out.println("Number Mode");
Scanner scan=new Scanner(System.in);
int flag_decimal_point=0;
if(input.equalsIgnoreCase("double")|input.equalsIgnoreCase("float"))
{
	flag_decimal_point=1;
}
String s=scan.next();
String num="";
while(!s.equalsIgnoreCase("end"))
{System.out.println("Number Mode");
if(s.equals("point")&& flag_decimal_point==1)
	{num+=".";}
else if(s.equalsIgnoreCase("zero"))
{num+="0";
}
else if(s.equalsIgnoreCase("one"))
{
	num+="1";
}
else if(s.equalsIgnoreCase("two"))
{
	num+="2";
}
else if(s.equalsIgnoreCase("three"))
{
	num+="3";
}
else if(s.equalsIgnoreCase("four"))
{
	num+="4";
}
else if(s.equalsIgnoreCase("five"))
{
	num+="5";
}
else if(s.equalsIgnoreCase("six"))
{
	num+="6";
}
else if(s.equalsIgnoreCase("seven"))
{
	num+="7";
}
else if(s.equalsIgnoreCase("eight"))
{
	num+="8";
}
else if(s.equalsIgnoreCase("nine"))
{
	num+="9";
}
System.out.println("Waiting for Input");
s=scan.next();
}
System.out.println("Number Recognized: "+num);
return num;

}

public static String characterRecognize()
{ System.out.println("Character Mode");
 Scanner scan=new Scanner(System.in);
 String s=scan.next();
 String characters="";;
while (!s.equalsIgnoreCase("end"))
{System.out.println("Character Mode");
if(s.equalsIgnoreCase("space"))	
	{
		characters+=" ";
	}
else if(s.equalsIgnoreCase("tab"))	
{
	characters+=" ";
}
else if(s.equalsIgnoreCase("return"))	
{
	characters+="\n";
}
else if(s.equalsIgnoreCase("not"))
{
	characters+="!";
}
else if(s.equalsIgnoreCase("at"))	
{
	characters+="@";
}
else if(s.equalsIgnoreCase("pound"))	
{
	characters+="#";
}
else if(s.equalsIgnoreCase("dollar"))	
{
	characters+="$";
}
else if(s.equalsIgnoreCase("percent"))	
{
	characters+="%";
}
else if(s.equalsIgnoreCase("exponent"))	
{
	characters+="^";
}
else if(s.equalsIgnoreCase("and"))	
{
	characters+="&";
}
else if(s.equalsIgnoreCase("or")||s.equalsIgnoreCase("pipe"))	
{
	characters+="|";
}
else if(s.equalsIgnoreCase("minus")||s.equalsIgnoreCase("dash"))	
{
	characters+="-";
}
else if(s.equalsIgnoreCase("score")||s.equalsIgnoreCase("under"))	
{
	characters+="_";
}
else if(s.equalsIgnoreCase("plus"))	
{
	characters+="+";
}
else if(s.equalsIgnoreCase("equal")||s.equalsIgnoreCase("equals"))	
{
	characters+="=";
}
else if(s.equalsIgnoreCase("star"))	
{
	characters+="*";
}
else if(s.equalsIgnoreCase("period")||s.equalsIgnoreCase("dot"))	
{
	characters+=".";
}
else if(s.equalsIgnoreCase("comma")||s.equalsIgnoreCase("come")||s.equalsIgnoreCase("coma"))	
{
	characters+=",";
}
else if(s.equalsIgnoreCase("question")||s.equalsIgnoreCase("quest"))	
{
	characters+="?";
}

else if(s.equalsIgnoreCase("great"))
{characters+=">";}

else if(s.equalsIgnoreCase("less"))
{characters+="<";}

else if(s.equalsIgnoreCase("braces"))	
{String next=scan.next();
	if(next.equalsIgnoreCase("open"))
	{characters+="(";}
else if(next.equalsIgnoreCase("close"))
	{characters+=")";}
}
else if(s.equalsIgnoreCase("block"))	
{String next=scan.next();
	if(next.equalsIgnoreCase("open"))
	{characters+="{";}
else if(next.equalsIgnoreCase("close"))
	{characters+="}";}
}
else if(s.equalsIgnoreCase("square"))	
{String next=scan.next();
	if(next.equalsIgnoreCase("open"))
	{characters+="[";}
else if(next.equalsIgnoreCase("close"))
	{characters+="]";}
}
	

else if(s.equalsIgnoreCase("quote"))	
	
{System.out.println("quote");
String next=scan.next();
if(next.equalsIgnoreCase("single"))
	{characters+="'";}
else if(next.equalsIgnoreCase("double"))
	{characters+="\"";}
}
else if(s.equalsIgnoreCase("slash"))
	
{   String next=scan.next();
	if(next.equalsIgnoreCase("forward"))
	{characters+="/";}
else if(next.equalsIgnoreCase("back"))
	{characters+="\\";}
}

else if(s.equalsIgnoreCase("colon"))	
{System.out.println("Colon");
String next=scan.next();
if(next.charAt(0)=='n')
{characters+=":";}
else if(next.charAt(0)=='s')
{characters+=";";}
}
System.out.println("Characters Recognized: "+characters);
System.out.println("Waiting for Input");
s=scan.next();}
System.out.println("Characters Recognized: "+characters);
return characters;}
	
public static String voiceDeclare(boolean value_flag)
{String str="";
System.out.println("Declare Mode");
Scanner scan=new Scanner(System.in);
System.out.println("Waiting for type: INTEGER FLOAT DOUBLE CHARACTER POINT LIST SPELL");
String s=scan.next();
if(s.equals("integer"))
	{System.out.println("Int mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
if(value_flag)
{System.out.println("Waiting for value");
 String value=numberRecognize(s);
 str=datatypes[0]+" "+name+" = "+value;
}
else
{
	str=datatypes[0]+" "+name;
}

	}
else if(s.equals("float"))
{System.out.println("Float mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
if(value_flag)
{System.out.println("Waiting for value");
String value=numberRecognize(s);
str=datatypes[1]+" "+name+" = "+value;}
else
	{str=datatypes[1]+" "+name;}
System.out.println(str);

}
else if(s.equals("character"))
{System.out.println("Character mode");
System.out.println("Waiting for name");
String name =scan.next();
if(value_flag)
{System.out.println("Waiting for value");
	char value=scan.next().charAt(0);
	 str=datatypes[2]+" "+name+" = "+"'"+value+"'";
}
else
{str=datatypes[2]+" "+name;}

}
else if(s.equals("double"))
{System.out.println("Double mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
if(value_flag)
{System.out.println("Waiting for value");
String value=numberRecognize(s);
 str=datatypes[3]+" "+name+" = "+value;}
else
{
	str=datatypes[3]+" "+name;
}

}
else if(s.equals("long"))
{
System.out.println("Long mode");
System.out.println("Waiting for name");
String name =alphabetRecognize();
if(value_flag)
{	System.out.println("Waiting for value");
	String value=numberRecognize(s);
	str=datatypes[4]+" "+name+" = "+value;
}
else
{
	str=datatypes[4]+" "+name;
}

}
else if(s.contains("point"))
{System.out.println("Pointer mode");
System.out.println("Waiting for type");
String type =scan.next();
if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
{   
	 if(type.equalsIgnoreCase("character"))
		{
		type="char";
		}
	if(type.equalsIgnoreCase("integer"))
		{
		type="int";
		}
	if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
		{
		type=alphabetRecognize();
		}
}
System.out.println("Waiting for name");
String name =alphabetRecognize();
if(value_flag)
{System.out.println("Waiting for value. Null if left undefined.");
String value=alphabetRecognize();
	if(value.length()>0)
	{
		str=type+"* "+name+" = NULL";
	}

	else
	{
		str=type+"* "+name+" = &"+value;
	}
}
else
{
	str=type+"* "+name;
}

}

else if(s.contains("list"))
{System.out.println("Array mode");
System.out.println("Waiting for type");
String type =scan.next();
if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
{   if(type.equalsIgnoreCase("character"))
	{
	type="char";
	}
	if(type.equalsIgnoreCase("integer"))
	{
		type="int";
	}
	
	
	if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
	{
		type=alphabetRecognize();
	}
}
System.out.println("Waiting for size");
String size=numberRecognize("integer");//No Value Flag - Does not assign values to array.
System.out.println("Waiting for name");
String name =alphabetRecognize();
//String value=alphabetRecognize();
 str=type+" "+name+"["+size+"]";

}

else if(s.equalsIgnoreCase("spell")||s.equalsIgnoreCase("sell"))
{System.out.println("User Control mode");
String value=alphabetRecognize();
 str=value;
}
return str+";\n";
}

public static String voiceStructure()
{   Scanner scan=new Scanner(System.in);
    String s="";
    String body="";
	System.out.println("Structure mode");
	System.out.println("Waiting for name");
    String name=alphabetRecognize();
	String structure= "struct " + name +" \n{";
	do
	{System.out.println("Waiting for struct members");
	body+= voiceDeclare(false);
	s=scan.next();}while(s.equalsIgnoreCase("next"));
	structure+=body;
	structure+="};\ntypedef struct "+name+" "+name+";";
	return structure;
}

public static String voicePrint()
{
	Scanner scan=new Scanner(System.in);
	System.out.println("Print mode");
	String all="";
	System.out.println("Waiting for message");
	String value =scan.next();
	while(!value.equalsIgnoreCase("end"))
	{ if(all.length()==0)
	{all+=value;}
	else
	{all=all+" "+value;}
	value=scan.next();
	
}
return "printf(\""+all+"\")";
}

public static String voiceControlStructures()
{System.out.println("Control Structures Mode");
	Scanner scan=new Scanner(System.in);
	System.out.println("Waiting for control structure: IF FOR WHILE DO-WHILE");
	String s=scan.next();
	String word="";
	if(s.startsWith("i"))
     {System.out.println("If Block");
	  String condition=alphabetRecognize();
      word+="if("+condition+")\n";
      String block=voiceBlocks();//replace 
      word+="{\n"+block+"\n}\n";
      String next=scan.next();
      if(next.equalsIgnoreCase("end"))
      {return word;}
      else if(next.equalsIgnoreCase("next"))
	   {do
	   {
    	  System.out.println("Else If Block");
		  String condition_next=alphabetRecognize();
	      word+="else if("+condition_next+")\n";
	      String block_next=voiceBlocks();//replace 
	      word+="{\n"+block_next+"\n}\n";
	      next=scan.next();
	   }while(next.equalsIgnoreCase("next"));
	   }
	  if(next.equalsIgnoreCase("last"))
	 {	  System.out.println("Else Block");
	      word+="else\n";
	      String block_last=voiceBlocks();//replace 
	      word+="{\n"+block_last+"\n}\n";
	      
	 }
	  }
	else if(s.equalsIgnoreCase("while"))
	{
		  System.out.println("While Block");
		  String condition=alphabetRecognize();
	      word+="while("+condition+")\n";
	      String block=voiceBlocks();//replace 
	      word+="{\n"+block+"\n}\n";
	      
	}
	else if(s.equalsIgnoreCase("for"))
	{
		  System.out.println("For Block");
		  String condition=alphabetRecognize();
	      word+="for("+condition+")\n";
	      String block=voiceBlocks();//replace 
	      word+="{\n"+block+"\n}\n";
	      
		
	}
	else if(s.startsWith("do"))
	{
		  System.out.println("For Block");
	      String block=voiceBlocks();//replace 
	      word+="do\n{\n"+block+"\n}\n";
		  String condition=voiceBlocks();
	      word+="while("+condition+");\n";
	    
	      
		
	}
return word;}

public static String voiceFunction()
{   System.out.println("Function Mode");
	Scanner scan=new Scanner(System.in);
	System.out.println("Waiting for Declare/Call");
	String declare_call=scan.next();
	String function="";
	if(declare_call.equalsIgnoreCase("declare"))
	{System.out.println("Declare Function Mode Waiting for Return Type VOID SPELL DATATYPES");
	String type =scan.next();
	if(!type.equalsIgnoreCase("double")||!type.equalsIgnoreCase("float")||!type.equalsIgnoreCase("long"))
	{   if(type.equalsIgnoreCase("character"))
		{
		type="char";
		}
		if(type.equalsIgnoreCase("integer"))
		{
			type="int";
		}
		if(type.equalsIgnoreCase("void") || type.equalsIgnoreCase("None") || type.equalsIgnoreCase("zero"))
		{
			type="void";
		}
		
		if(type.equalsIgnoreCase("spell")||type.equalsIgnoreCase("sell"))
		{
			type=alphabetRecognize();
		}
	}
	function+=type+" ";
	System.out.println("Waiting for funciton name");
	String name=alphabetRecognize();
	System.out.println("Waiting for Parameters");
	function+=name;
	String s=scan.next();
	String parameter="";
	String parameters="";
	boolean void_flag=true;

	if(!s.equalsIgnoreCase("void") && !s.equalsIgnoreCase("None") && !s.equalsIgnoreCase("zero"))
		{void_flag=false;
		do
		{if(!s.equalsIgnoreCase("double")||!s.equalsIgnoreCase("float")||!s.equalsIgnoreCase("long"))//else if replace put segment inside function.
	{   if(s.equalsIgnoreCase("character"))
		{
		parameter="char";
		}
		if(s.equalsIgnoreCase("integer"))
		{
			parameter="int";
		}
		
		
		if(s.equalsIgnoreCase("spell")||s.equalsIgnoreCase("sell"))
		{
			parameter=alphabetRecognize();
		}
	}    if(parameters.length()==0)
	      {parameters+=parameter;}
	     else
		 {parameters+=", "+parameter;}
		 s=scan.next();
		}while(s.equalsIgnoreCase("next"));
		}
	System.out.println("Waiting for block");
	String block=voiceBlocks();
	function+="("+parameters+")\n{\n"+block+"\n}";}
    
	else if(declare_call.equalsIgnoreCase("call"))
	{System.out.println("Waiting for function Call");
		function=alphabetRecognize();
		String parameters="";
		String s;
		do
		{
		String parameter=alphabetRecognize();
		 if(parameters.length()==0)
	      {parameters+=parameter;}
	     else
		 {parameters+=", "+parameter;}
		 s=scan.next();
	}while(s.equalsIgnoreCase("next"));
	}
return function;}

public static String voiceInput()
{
	Scanner scan=new Scanner(System.in);
	System.out.println("Input mode");
	String all="";
	System.out.println("Waiting for value");
	String value =scan.next();
	System.out.println("Waiting for variable type");
	String variable=alphabetRecognize();
	String variables="";
	while(!value.equalsIgnoreCase("end"))
	{ if(value.equalsIgnoreCase("integer"))
		{value="%d";
		}
	else if(value.equalsIgnoreCase("character"))
		{value="%c";}
	else if(value.equalsIgnoreCase("float"))
	{value="%f";}
	else if(value.equalsIgnoreCase("double"))
	{value="%lf";}
	else if(value.equalsIgnoreCase("long"))
	{value="%ld";}
	else if(value.equalsIgnoreCase("string"))
	{value="%s";}
	
	if(all.length()==0)
	{all+=value;
	variables+="&"+variable;}
	else
	{
	all=all+" "+value;
	variables +=", &"+variable;}
	System.out.println("Waiting for next variable type");
	value=scan.next();
	if(value.equalsIgnoreCase("end"))
	{
		break;
	}
	System.out.println("Waiting for next variable name");
	variable=scan.next();
}

return "scanf(\""+all+"\","+variables+");";
}
	

public static String voiceBlocks()

{   System.out.println("Block Mode");
	Scanner scan=new Scanner(System.in);
	String block="";
	String s=scan.next();
	while(!s.equalsIgnoreCase("exit"))
	{
		if(s.equalsIgnoreCase("declare"))
		{
			block+=voiceDeclare(true);
		}
		else if(s.equalsIgnoreCase("change"))
		{String word=alphabetRecognize();
		 block+=word+"\n";
		}
		else if(s.equalsIgnoreCase("input"))
		{
			block+=voiceInput()+"\n";
		}
		else if(s.equals("print"))
		{block+=voicePrint()+";\n";}
		else if(s.equalsIgnoreCase("structure"))
		{
			block+=voiceStructure()+"\n";
		}
		else if(s.equalsIgnoreCase("function"))
		{
			block+=voiceFunction()+"\n";
		}
		else if(s.equalsIgnoreCase("spell"))
		{String word=alphabetRecognize();
		 block+=word+";\n";
		}
	System.out.println("Waiting for Block");	
	s=scan.next();}
	return block;
}
	
	public static void main(String args[])
	{
//	{   Desktop dt = Desktop.getDesktop();
//    try {
//		dt.open( new File("FileName.csv") );
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
		
		//String [] keywords={ "int","float","char","double"};
		Scanner scan=new Scanner(System.in);
		String s="";
		while(!s.equalsIgnoreCase("exit"))
		{System.out.println("Main Mode");
		s=scan.next();
		if(s.equals("declare"))
		do
		{prog+=voiceDeclare(true);
		s=scan.next();
		}
		while(s.equals("next"));
		
		else if(s.equalsIgnoreCase("include"))
		{
			String include=voiceInclude();
			prog+=include+"\n";
		}
	    
		else if(s.equalsIgnoreCase("structure"))
		{
			prog+=voiceStructure()+"\n";
		}
		else if(s.equalsIgnoreCase("function"))
		{
			prog+=voiceFunction()+"\n";
		}
		else if(s.equals("print"))
		{prog+=voicePrint()+";\n";}
		

		else if(s.equalsIgnoreCase("character"))
		{String word=characterRecognize();
		 prog+=word+"\n";
		}
		else if(s.equalsIgnoreCase("change"))//use only if there is a running list of  variables
		{String word=alphabetRecognize();
		 prog+=word+"\n";
		}
		else if(s.equalsIgnoreCase("control"))
		{String word=voiceControlStructures();
		 prog+=word+"\n";
		}
		else if(s.equalsIgnoreCase("input"))
		{
			prog+=voiceInput()+"\n";
		}
		
		else if(s.equalsIgnoreCase("spell"))
		{String word=alphabetRecognize();
		 prog+=word+";\n";
		}

		System.out.println(prog);}
		////System.out.println(prog.contains("stdio"));
		//prog=prog.replace("stdio","string");
		System.out.println(prog);
		scan.close();

}
}

