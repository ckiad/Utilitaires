/**
 * 
 */
package convertion;

import java.util.StringTokenizer;

/**
 * @author cedrickiadjeu
 *
 */
public class ConvertNumber {

	public String[] ch_unites = {"zéro", "un", "deux", "trois", "quatre", "cinq", "six", "sept",
	                  "huit","neuf", "dix", "onze", "douze", "treize", "quatorze",
	                    "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf"};
	
	public String[] ch_dizaines = {"", "", "vingt", "trente", "quarante", "cinquante", "soixante",
			"", "quatre-vingt"};
	
	public String[] ch_units = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight","nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
              "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	public String[] ch_tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty",
			"seventy", "eighty", "ninety"};
	
	public String imprimeNombreDeux9(long nbre, boolean accord){
		String chaine_result="";
		int nbre_dizaines;
		int nbre_unites;
		if(nbre>=20){
			//System.out.println("nbre>=20");
			if(nbre>=60){
				//System.out.println("nbre>=60");
				nbre_dizaines=2*((new Long(nbre)).intValue()/20);
				nbre_unites=(new Long(nbre)).intValue()%20;
			}
			else{
				nbre_dizaines=(new Long(nbre)).intValue()/10;
				nbre_unites=(new Long(nbre)).intValue()%10;
				//System.out.println("nbre_dizaines="+nbre_dizaines+" nbre_unites="+nbre_unites);
			}
			
			chaine_result+=this.ch_dizaines[nbre_dizaines];
			//System.out.println("on ajoute "+this.ch_dizaines[nbre_dizaines]+" car nbre_dizaines="+nbre_dizaines);
			
			if(accord==true && nbre_dizaines==8 && nbre_unites==0){
				chaine_result+="s";
				//System.out.println("on ajoute s");
			}
			
			if((nbre_unites%10==1) && nbre_dizaines!=8){
				chaine_result+=" et ";
				//System.out.println("on ajoute et");
			}
			else if(nbre_unites!=0){
				chaine_result+="-";
				//System.out.println("on ajoute -");
			}
		}
		else{
			nbre_unites=(new Long(nbre)).intValue();
		}
		
		if(nbre==0 || nbre_unites!=0){
			chaine_result+=this.ch_unites[nbre_unites];
			//System.out.println("on ajoute "+this.ch_unites[nbre_unites]+" car nbre_unites="+nbre_unites);
		}
		
		return chaine_result;
	}
	
	public String printNumberTwo9(long nbre){
		String chaine_result="";
		int nbre_tens;
		int nbre_units;
		if(nbre>=20){
			nbre_tens=(new Long(nbre)).intValue()/10;
			nbre_units=(new Long(nbre)).intValue()%10;
			chaine_result+=this.ch_tens[nbre_tens];
			if(nbre_units!=0){
				chaine_result+="-";
			}
		}
		else{
			nbre_units=(new Long(nbre)).intValue();
		}
		if(nbre==0 || nbre_units!=0){
			chaine_result+=this.ch_units[nbre_units];
		}
		return chaine_result;
	}
	
	public String imprimeNombreTrois9(long nbre, boolean accord){
		String chaine_result="";
		int nbre_centaines;
		int nbre99;
		
		nbre_centaines=(new Long(nbre)).intValue()/100;
		nbre99=(new Long(nbre)).intValue()%100;
		
		if(nbre_centaines>=1){
			if(nbre_centaines>=2){
				chaine_result+=this.ch_unites[nbre_centaines];
				chaine_result+=" ";
			}
			
			chaine_result+="cent";
			if(accord==true && nbre_centaines>=2 && nbre99==0){
				chaine_result+="s";
			}
			
			if(nbre99!=0){
				chaine_result+=" ";
			}
		}
		
		if(nbre==0 || nbre99!=0){
			String chaine_result99=imprimeNombreDeux9(nbre99, accord);
			chaine_result+=chaine_result99;
		}
		
		return chaine_result;
	}
	
	public String printNumberThree9(long nbre){
		String chaine_result="";
		int nbre_hundred;
		int nbre99;
		
		nbre_hundred=(new Long(nbre)).intValue()/100;
		nbre99=(new Long(nbre)).intValue()%100;
		if(nbre_hundred>0){
			chaine_result+=this.ch_units[nbre_hundred];
			chaine_result+=" ";
			chaine_result+="hundred";
		}
		if(nbre_hundred>0 && nbre99>0){
			chaine_result+=" ";
			chaine_result+="and";
			chaine_result+=" ";
			chaine_result+=printNumberTwo9(nbre99);
		}
		
		if(nbre_hundred==0 && nbre99>0){
			chaine_result+=printNumberTwo9(nbre99);
		}
		
		
		return chaine_result;
	}
	
	public String imprimeNombreQuatre9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_milliers;
		long nbre999;
		
		nbre_milliers=nbre/1000;
		nbre999=nbre%1000;
		
		if(nbre_milliers>=1){
			if(nbre_milliers>=2){
				String chaine_result999=imprimeNombreTrois9(nbre_milliers, false);
				chaine_result+=chaine_result999;
				chaine_result+=" ";
			}
			
			chaine_result+="mille";
			
			if(nbre999!=0){
				chaine_result+=" ";
			}
		}
		
		if(nbre==0 || nbre999!=0){
			String chaine_result999=imprimeNombreTrois9(nbre999, true);
			chaine_result+=chaine_result999;
		}
		
		return chaine_result;
	}
	
	public String printNumberFour9(long nbre){
		String chaine_result="";
		long nbre_thousand;
		long nbre999;
		
		nbre_thousand=nbre/1000;
		nbre999=nbre%1000;
		
		chaine_result+=printNumberThree9(nbre_thousand);
		chaine_result+=" ";
		chaine_result+="thousand";
		chaine_result+=" ";
		chaine_result+=printNumberThree9(nbre999);
		
		return chaine_result;
	}
	
	public String imprimeNombreCinq9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_dizaine_milliers;
		long nbre9999;
		
		nbre_dizaine_milliers=nbre/1000;
		nbre9999=nbre%1000;
		
		if(nbre_dizaine_milliers>=1){
			if(nbre_dizaine_milliers>=2){
				String chaine_result9999=imprimeNombreQuatre9(nbre_dizaine_milliers, false);
				chaine_result+=chaine_result9999;
				chaine_result+=" ";
			}
			chaine_result+="mille";
			if(nbre9999!=0){
				chaine_result+=" ";
			}
			
		}
		
		if(nbre==0 || nbre9999!=0){
			String chaine_result9999=imprimeNombreQuatre9(nbre9999, true);
			chaine_result+=chaine_result9999;
		}
		
		return chaine_result;
	}
	
	public String printNumberFive9(long nbre){
		String chaine_result="";
		long nbre_thousand;
		long nbre9999;
		
		nbre_thousand=nbre/1000;
		nbre9999=nbre%1000;
		
		chaine_result+=printNumberTwo9(nbre_thousand);
		chaine_result+=" ";
		chaine_result+="thousand";
		chaine_result+=" ";
		chaine_result+=printNumberThree9(nbre9999);
		
		return chaine_result;
	}
	
	public String imprimeNombreSix9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_centaine_milliers;
		long nbre99999;
		
		nbre_centaine_milliers=nbre/1000;
		nbre99999=nbre%1000;
		
		if(nbre_centaine_milliers>=1){
			if(nbre_centaine_milliers>=2){
				String chaine_result99999=imprimeNombreCinq9(nbre_centaine_milliers, false);
				chaine_result+=chaine_result99999;
				chaine_result+=" ";
			}
			chaine_result+="mille";
			if(nbre99999!=0){
				chaine_result+=" ";
			}
			
		}
		
		if(nbre==0 || nbre99999!=0){
			String chaine_result99999=imprimeNombreCinq9(nbre99999, true);
			chaine_result+=chaine_result99999;
		}
		
		return chaine_result;
	}
	
	public String printNumberSix9(long nbre){
		String chaine_result="";
		long nbre_thousand;
		long nbre99999;
		
		nbre_thousand=nbre/1000;
		nbre99999=nbre%1000;
		if(nbre_thousand>0){
			chaine_result+=printNumberThree9(nbre_thousand);
			chaine_result+=" ";
			chaine_result+="thousand";
			chaine_result+=" ";
		}
		if(nbre99999>0){
			chaine_result+=printNumberThree9(nbre99999);
		}
		
		return chaine_result;
	}
	
	public String imprimeNombreNeuf9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_millions;
		long nbre999999;
		
		nbre_millions=nbre/1000000;
		nbre999999=nbre%1000000;
		
		if(nbre_millions>=1){
			//System.out.println("if1");
			if(nbre_millions>=2){
				//System.out.println("if2");
				String chaine_result999999=imprimeNombreTrois9(nbre_millions, false);
				chaine_result+=chaine_result999999;
				chaine_result+=" ";
				//System.out.println("1=="+chaine_result);
			}
			else if(nbre_millions==1){
				chaine_result+="un ";
				//System.out.println("A1=="+chaine_result);
			}
			chaine_result+="million";
			//System.out.println("2=="+chaine_result);
			
			if(nbre_millions>1){
				chaine_result+="s";
			}
			
			if(nbre999999!=0){
				//System.out.println("if4");
				chaine_result+=" ";
				//System.out.println("3=="+chaine_result);
			}
			
		}
		
		if(nbre==0 || nbre999999!=0){
			//System.out.println("if5");
			String chaine_result999999=imprimeNombreSix9(nbre999999, true);
			chaine_result+=chaine_result999999;
			//System.out.println("4=="+chaine_result);
		}
		//System.out.println("5=="+chaine_result);
		return chaine_result;
	}
	
	public String printNumberNine9(long nbre){
		String chaine_result="";
		long nbre_million;
		long nbre999999;
		
		nbre_million=nbre/1000000;
		nbre999999=nbre%1000000;
		if(nbre_million>0){
			chaine_result+=printNumberThree9(nbre_million);
			chaine_result+=" ";
			chaine_result+="million";
			chaine_result+=" ";
		}
		if(nbre999999>0){
			chaine_result+=printNumberSix9(nbre999999);
		}
		
		return chaine_result;
	}
	
	public String imprimeNombreDouze9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_milliards;
		long nbre999999999;
		
		nbre_milliards=nbre/1000000000;
		nbre999999999=nbre%1000000000;
		
		if(nbre_milliards>=1){
			//System.out.println("if6");
			if(nbre_milliards>=2){
				//System.out.println("if7");
				String chaine_result999999999=imprimeNombreTrois9(nbre_milliards, false);
				chaine_result+=chaine_result999999999;
				chaine_result+=" ";
				//System.out.println("6=="+chaine_result);
			}
			else if(nbre_milliards==1){
				chaine_result+="un ";
				//System.out.println("B1=="+chaine_result);
			}
			chaine_result+="milliard";
			//System.out.println("7=="+chaine_result);
			
			if(nbre_milliards>1){
				chaine_result+="s";
			}
			
			if(nbre999999999!=0){
				//System.out.println("if8");
				chaine_result+=" ";
				//System.out.println("8=="+chaine_result);
			}
			
		}
		
		if(nbre==0 || nbre999999999!=0){
			//System.out.println("if9");
			String chaine_result999999999=imprimeNombreNeuf9(nbre999999999, true);
			chaine_result+=chaine_result999999999;
			//System.out.println("9=="+chaine_result);
		}
		//System.out.println("10=="+chaine_result);
		return chaine_result;
	}
	
	public String printNumberTwelve9(long nbre){
		String chaine_result="";
		long nbre_billion;
		long nbre9999999;
		
		nbre_billion=nbre/1000000000;
		nbre9999999=nbre%1000000000;
		if(nbre_billion>0){
			chaine_result+=printNumberThree9(nbre_billion);
			chaine_result+=" ";
			chaine_result+="billion";
			chaine_result+=" ";
		}
		if(nbre9999999>0){
			chaine_result+=printNumberNine9(nbre9999999);
		}
		
		return chaine_result;
	}
	
	public String imprimeNombrePlusDeDouze9(long nbre, boolean accord){
		String chaine_result="";
		long nbre_milliards;
		long nbrePlusDeNeuf9;
		
		String s_diviseur="1000000000";
		long diviseur=Long.parseLong(s_diviseur);
		
		nbre_milliards=nbre/diviseur;
		nbrePlusDeNeuf9=nbre%diviseur;
		
		if(nbre_milliards<1){
			chaine_result+= imprimeNombreDouze9(nbre,accord);
		}
		else{
			chaine_result+= imprimeNombreDouze9(nbre_milliards,accord);
			chaine_result+= " ";
			chaine_result+= "milliard";
			if(nbre_milliards>1){
				chaine_result+= "s";
			}
			chaine_result+= " ";
			chaine_result+= imprimeNombreDouze9(nbrePlusDeNeuf9,accord);
		}
		
		return chaine_result;
	}
	
	public String printNumberOverTwelve9(long nbre){
		String chaine_result="";
		long nbre_billion;
		long nbre99999999;
		
		String s_diviseur="1000000000";
		long diviseur=Long.parseLong(s_diviseur);
		
		nbre_billion=nbre/diviseur;
		nbre99999999=nbre%diviseur;
		
		if(nbre_billion<1){
			chaine_result+= printNumberTwelve9(nbre);
		}
		else{
			chaine_result+= printNumberTwelve9(nbre_billion);
			chaine_result+= " ";
			chaine_result+= "billion";
			chaine_result+= " ";
			chaine_result+= printNumberTwelve9(nbre99999999);
		}
		
		return chaine_result;
	}
	
	public String chaiine(int num){
		String c="";
		int d=num/10; 
		int nbre_chiffre_num=1;
		while(d!=0){
			nbre_chiffre_num+=1;
			d=num/10;
		}
		int nbre_0=6-nbre_chiffre_num;
		for(int i=0;i<nbre_0;i++){
			c+="0";
		}
		c+=num;
		return c;
	}
	
	
	public  String tronque(String chaine, int nbDecimales) {
	      String avant;
	      String apres;

	      StringTokenizer st = new StringTokenizer(chaine,"."); 
	      if(st.countTokens()>2) return null;
	      avant = st.nextToken(); 
	      if (st.hasMoreTokens()) apres = st.nextToken(); 
	      else return avant;
	      
	     if (apres.length() <= nbDecimales) return chaine;
	      return chaine.substring(0, chaine.length() - 
				      apres.length() + nbDecimales);
	    }
	
	public double tronqueDouble(double nbre, int nbDecimales){
		double d=-100000000;
		String nbre_a_tronque = ""+nbre;
		String nbre_tronque = this.tronque(nbre_a_tronque, nbDecimales);
		if(nbre_tronque!=null){
			d = Double.parseDouble(nbre_tronque);
		}
		return d;
	}
	
	
	/**
	 * 
	 */
	public ConvertNumber() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Troncage des nombres");
		
		System.out.println("Nombre tronque "+new ConvertNumber().tronqueDouble(-115.299, 2));
		
		System.out.println("la chaine liste des operations est  "+new ConvertNumber().chaiine(14));
		
		String n_s="37500";
		long n=Long.parseLong(n_s);
		String chaine=new ConvertNumber().printNumberOverTwelve9(n);
		System.out.println("la chaine Twelve9  est "+chaine);
		
		n_s="37500";
		n=Long.parseLong(n_s);
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(n, true);
		System.out.println("la chaine 8 "+chaine);
		
		/*String chaine=new ConvertNumber().printNumberTwo9(78);
		System.out.println("la chaine Two9 de 68 est "+chaine);
		
		chaine=new ConvertNumber().printNumberThree9(1);
		System.out.println("la chaine Three9 de 1 est "+chaine);
		
		chaine=new ConvertNumber().printNumberFour9(9111);
		System.out.println("la chaine Four9 de 9111 est "+chaine);
		
		chaine=new ConvertNumber().printNumberFive9(10000);
		System.out.println("la chaine Five9 de 10002 est "+chaine);
		
		chaine=new ConvertNumber().printNumberSix9(900001);
		System.out.println("la chaine Six9 de 900001 est "+chaine);
		
		chaine=new ConvertNumber().printNumberNine9(115900001);
		System.out.println("la chaine Nine9 de 115900001 est "+chaine);
		
		chaine=new ConvertNumber().printNumberNine9(1000011);
		System.out.println("la chaine Nine9 de 1000011 est "+chaine);
		
		String n_s="215999546111";
		long n=Long.parseLong(n_s);
		chaine=new ConvertNumber().printNumberTwelve9(n);
		System.out.println("la chaine Twelve9 de  215999546111 est "+chaine);
		
		n_s="1000000000";
		n=Long.parseLong(n_s);
		chaine=new ConvertNumber().printNumberOverTwelve9(n);
		System.out.println("la chaine Twelve9 de  1000000000 est "+chaine);
		
		n_s="100215999546111";
		n=Long.parseLong(n_s);
		chaine=new ConvertNumber().printNumberOverTwelve9(n);
		System.out.println("la chaine Twelve9 de  100215999546101 est "+chaine);*/
		
		
		/*System.out.println("Départ de l'exécution");
		System.out.println("la chaine est "+new ConvertNumber().ch_unites[0]);
		
		String chaine=new ConvertNumber().imprimeNombreDeux9(91, true);
		System.out.println("la chaine Deux9 est "+chaine);
		
		chaine=new ConvertNumber().imprimeNombreTrois9(476, true);
		System.out.println("la chaine Trois9 est "+chaine);
		
		chaine=new ConvertNumber().imprimeNombreQuatre9(2018, true);
		System.out.println("la chaine Quatre9 est "+chaine);
		
		chaine=new ConvertNumber().imprimeNombreCinq9(99999, true);
		System.out.println("la chaine Cinq9 est "+chaine);
		
		chaine=new ConvertNumber().imprimeNombreSix9(398999, true);
		System.out.println("la chaine Six9 est "+chaine);
		
		chaine=new ConvertNumber().imprimeNombreNeuf9(1398999, true);
		System.out.println("la chaine Neuf9 est "+chaine);
		
		String n_s="211980398999";
		long n=Long.parseLong(n_s);
		chaine=new ConvertNumber().imprimeNombreDouze9(n, true);
		System.out.println("la chaine Douze9 est "+chaine);
		
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(91, true);
		System.out.println("la chaine 1 "+chaine);
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(476, true);
		System.out.println("la chaine 2"+chaine);
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(3218, true);
		System.out.println("la chaine 3"+chaine);
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(99999, true);
		System.out.println("la chaine 4 "+chaine);
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(398999, true);
		System.out.println("la chaine 5 "+chaine);
		
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(1398999, true);
		System.out.println("la chaine 6 "+chaine);
		n_s="211980398999";
		n=Long.parseLong(n_s);
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(n, true);
		System.out.println("la chaine 7 "+chaine);
		n_s="984299211980398999";
		n=Long.parseLong(n_s);
		chaine=new ConvertNumber().imprimeNombrePlusDeDouze9(n, true);
		System.out.println("la chaine 8 "+chaine);*/
		
	}

}
