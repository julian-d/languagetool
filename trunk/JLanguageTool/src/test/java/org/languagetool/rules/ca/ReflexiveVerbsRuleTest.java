/* LanguageTool, a natural language style checker 
 * Copyright (C) 2012 Jaume Ortolà
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.ca;

import java.io.IOException;

import junit.framework.TestCase;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.rules.RuleMatch;

/**
 * @author Jaume Ortolà
 */
public class ReflexiveVerbsRuleTest extends TestCase {

	private ReflexiveVerbsRule rule;
	private JLanguageTool langTool;

	@Override
	public void setUp() throws IOException {
		rule = new ReflexiveVerbsRule(null);
		langTool = new JLanguageTool(Language.CATALAN);
	}

	public void testRule() throws IOException { 

		// correct sentences:
		assertCorrect("ens anem a aferrissar");
		assertCorrect("anem a aferrissar-nos");
		assertCorrect("ens preparem per a anar");
		assertCorrect("comencen queixant-se");
		assertCorrect("comenceu a queixar-vos");
		assertCorrect("em puc queixar");
		assertCorrect("en teniu prou amb queixar-vos");
		assertCorrect("ens en podem queixar");
		assertCorrect("es queixa");
		assertCorrect("es va queixant");
		assertCorrect("es va queixar");
		assertCorrect("has d'emportar-t'hi");
		assertCorrect("has de poder-te queixar");
		assertCorrect("t'has de poder queixar");
		assertCorrect("havent-se queixat");
		assertCorrect("haver-se queixat");
		assertCorrect("no es va poder emportar");
		assertCorrect("no has de poder-te queixar");
		assertCorrect("no has de queixar-te");
		assertCorrect("no podeu deixar de queixar-vos");
		assertCorrect("no t'has de queixar");
		assertCorrect("no us podeu deixar de queixar");
		assertCorrect("pareu de queixar-vos");
		assertCorrect("podent abstenir-se");
		assertCorrect("poder-se queixar");
		assertCorrect("podeu queixar-vos");
		assertCorrect("queixa't");
		assertCorrect("queixant-vos");
		assertCorrect("queixar-se");
		assertCorrect("queixeu-vos");
		assertCorrect("s'ha queixat");
		assertCorrect("se li ha queixat");
		assertCorrect("se li queixa");
		assertCorrect("se li va queixar");
		assertCorrect("va decidir suïcidar-se");
		assertCorrect("va queixant-se");
		assertCorrect("va queixar-se");
		assertCorrect("va queixar-se-li");
		assertCorrect("Se'n pujà al cel");
		assertCorrect("Se li'n va anar la mà");
		assertCorrect("El nen pot callar");
		assertCorrect("es va desfent");
		assertCorrect("s'ha anat configurant");	
		assertCorrect("s'han anat fabricant amb materials");
		assertCorrect("la matèria que cau s'accelera");
		assertCorrect("Altres muntanyes foren pujades per pastors, caçadors o aventurers.");
		assertCorrect("mai assolí èxit social");
		assertCorrect("Aquests polímers són lineals i no ramificats.");
		assertCorrect("tornaven a assolar la Vall de l'Ebre.");
		assertCorrect("està previst que s'acabin per a anar directament a la zona");
		assertCorrect("es deixaven caure");
		assertCorrect("es van deixar caure");
		assertCorrect("van deixar-se caure");
		assertCorrect("et deixaves pujar");
		assertCorrect("Els animals es feien témer amb cops secs de ferro");
		assertCorrect("es veié obligat a marxar el 1512.");
		assertCorrect("Francesc III es va anar a asseure sobre el tron");
		assertCorrect("Va anar a dutxar-se");
		assertCorrect("es van deixar anar molts empresonats.");
		assertCorrect("A Joan se li'n va anar la mà");
		assertCorrect("se'ns en va anar la mà");
		assertCorrect("ja que si l'arròs se sega molt verd");
		assertCorrect("s'hi afegeixen bolets abans d'enfundar-la en l'intestí");
		assertCorrect("Joan ha anat a fer-se la prova.");
		//assertCorrect("Joan s'ha anat a fer la prova."); -->dubtós
		//assertCorrect("Cada grup s'ha anat a fer la prova."); -->dubtós
		assertCorrect("Cada grup s'ha anat a dutxar.");
		assertCorrect("Joan ha anat a dutxar-se.");
		assertCorrect("Joan s'ha anat a dutxar.");
		assertCorrect("amb els Confederats intentant burlar el bloqueig a Maryland.");
		//IMPERSONALS
		assertCorrect("Se'l va fer callar.");
		assertCorrect("Se li va fer callar."); //incorrecta per una altra qüestió
		assertCorrect("Se'ns va fer callar.");
		assertCorrect("També es canta quan es va a pasturar als animals");		
		assertCorrect("Quan es baixa a l'ordinador de l'usuari,");
		assertCorrect("sinó que es baixa per parts a l'atzar.");
		assertCorrect("Es tem que la radioactivitat afecti la població local");
		assertCorrect("Després de tot això es va témer la possibilitat");
		assertCorrect("probablement es vagi a destil·lar l'etanol");
		assertCorrect(", es podia anar a Madrid per aconseguir en Celebi");
		assertCorrect("Els soldats es preparen per a marxar a la guerra.");
		assertCorrect("Tu et prepares per marxar a la guerra.");
		assertCorrect("i que es temia que s'aconseguís el nombre previst.");
		assertCorrect("Des del principi es temia el pitjor");
		assertCorrect("La primera muntanya que es va pujar per motius purament esportius,");
		assertCorrect("Quan el so era via fora, s'anava a guerrejar fora de la terra.");
		assertCorrect("els algorismes, de manera que s'evita caure");
		assertCorrect("En acabar l'assalt, és comú que es pugi un banc");
		assertCorrect("Es va caure en la provocació.");
		assertCorrect("Abans d'això ja s'havien pujat muntanyes,");
		assertCorrect("a una representació de La Passió no només s'hi va a veure un espectacle sumptuós");
		assertCorrect("A escola no s'hi va a plorar.");
		assertCorrect("A escola no es va a jugar.");
		assertCorrect("A escola no es va a plorar.");
		assertCorrect("Joan no es va a jugar la feina.");	
		
		 	
		// errors:
		assertIncorrect("un dels pocs moviments que poden fer és intentar pujar-se al carro de la indignació.");
		assertIncorrect("és intentar pujar-se al carro de la indignació.");
		assertIncorrect("Pujar-se al carro de la indignació.");
		assertIncorrect("Pujar-vos al carro de la indignació.");
		assertIncorrect("se li va caure la cara de vergonya");
		assertIncorrect("se'ns va caure la cara de vergonya");
		assertIncorrect("A mi se'm va caure la cara de vergonya");
		assertIncorrect("Joan no es va a l'escola");
		assertIncorrect("que el procés no se'ns vagi de les mans");
		assertIncorrect("Ho volen per a anar-se de la zona"); 
		assertIncorrect("Ho volen per anar-se de la zona"); 
		assertIncorrect("Ho desitgen per anar-se de la zona"); 
		assertIncorrect("els grups que es van caure del cartell");
		assertIncorrect("el nen que es va caure al pou");//--> Es pot tractar diferent: caure / anar
		assertCorrect("el dia que es va anar a la ciutat");
		//assertIncorrect("el dia que es va anar a la ciutat");
		assertIncorrect("tot l'auditori es callà");
		assertIncorrect("les gotes que es van caure fora"); 
		assertIncorrect("Ells s'han baixat del tren.");
		assertIncorrect("Se'ns va callar.");
		assertIncorrect("Tothom es va callar.");
		assertIncorrect("Els nens van poder-se caure");	
		assertIncorrect("Aleshores ell es va anar a estudiar a Barcelona"); //-->va anar a fer introspecció :-)
		assertIncorrect("Joan es va anar a estudiar a Barcelona.");
		assertIncorrect("se'ns va anar la mà");
		assertIncorrect("Es van caure en la trampa.");
		assertIncorrect("Aleshores es van anar a la ciutat a presentar una queixa.");
		//assertIncorrect("Aleshores es va anar a la ciutat a presentar una queixa.");
		//assertIncorrect("quan es pugen, permeten canviar de feina.");
		assertIncorrect("havent queixat");
		assertIncorrect("haver queixat");
		assertIncorrect("les membranes s'han anat fabricat amb materials sintètics"); 
		assertIncorrect("s'han anat fabricat amb materials sintètics");
		assertIncorrect("Holmes i Watson s'han anat d'acampada");
		assertIncorrect("L'independentisme s'ha anat a Brussel·les!");
		assertIncorrect("El seu marit s'ha anat a la Xina per negocios");
		assertIncorrect("L'home es marxà de seguida");
		assertIncorrect("L'home s'anà de seguida");
		assertIncorrect("A Joan se li va caure la cara de vergonya");
		assertIncorrect("El nen es cau");
		assertIncorrect("El nen se li cau");
		assertIncorrect("A la nena se li caigueren les arracades");
		assertIncorrect("El nen s'ha de caure");
		assertIncorrect("El nen pot caure's");
		assertIncorrect("Calleu-vos");
		//assertIncorrect("Es pujà al cel"); ->indecidible
		assertIncorrect("El berenar es pujà al cel");
		assertIncorrect("Va baixar-se del cotxe en marxa.");
		assertIncorrect("A Joan se li va anar la mà");	
		assertIncorrect("Al pare se li va anar la mà");	
   		assertIncorrect("Escriu que quan era mosso «se li anaven els ulls»");
		assertIncorrect("comencen queixant");
		assertIncorrect("comenceu a queixar-nos");
		assertIncorrect("et puc queixar");
		assertIncorrect("en teniu prou amb queixar");
		assertIncorrect("en podem queixar");
		assertIncorrect("et queixa");
		assertIncorrect("em va queixant");
		assertIncorrect("li va queixar");
		assertIncorrect("hem d'emportar-t'hi");
		assertIncorrect("heu de poder-te queixar");
		assertIncorrect("m'has de poder queixar");
		assertIncorrect("havent queixat");
		assertIncorrect("haver queixat");
		assertIncorrect("no es vam poder emportar");
		assertIncorrect("no has de poder-vos queixar");
		assertIncorrect("no has de queixar-ne");
		assertIncorrect("no podeu deixar de queixar-ne");
		assertIncorrect("no li has de queixar");
		assertIncorrect("no em podeu deixar de queixar");
		assertIncorrect("pareu de queixar-se'n");
		assertIncorrect("podent abstenir");
		assertIncorrect("poder queixar");
		assertIncorrect("podeu queixar");
		assertIncorrect("queixa'n");
		assertIncorrect("queixant");
		assertIncorrect("queixar");
		assertIncorrect("queixeu-se'n");
		assertIncorrect("de n'ha queixat");
		assertIncorrect("me li ha queixat");
		assertIncorrect("te li queixa");
		assertIncorrect("us li va queixar");
		assertIncorrect("va decidir suïcidar-me");
		assertIncorrect("va queixant");
		assertIncorrect("va queixar");
		assertIncorrect("va queixar-li");
		assertIncorrect("anem a aferrissar");
	}

	private void assertCorrect(String sentence) throws IOException {
		final RuleMatch[] matches = rule.match(langTool.getAnalyzedSentence(sentence));
		assertEquals(0, matches.length);
	}

	private void assertIncorrect(String sentence) throws IOException {
		final RuleMatch[] matches = rule.match(langTool.getAnalyzedSentence(sentence));
		assertEquals(1, matches.length);
	}

}