/* LanguageTool, a natural language style checker 
 * Copyright (C) 2010 Marcin Miłkowski (www.languagetool.org)
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

package org.languagetool.rules.bitext;

import java.io.IOException;

import junit.framework.TestCase;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.rules.RuleMatch;

public class DifferentLengthRuleTest extends TestCase {
  
  public void testRule() throws IOException {
    final DifferentLengthRule rule = new DifferentLengthRule();
      //(TestTools.getEnglishMessages(), Language.ENGLISH);
    RuleMatch[] matches;
    final JLanguageTool trgLangTool = new JLanguageTool(Language.DEMO);
    final JLanguageTool srcLangTool = new JLanguageTool(new FakeLanguage());
    rule.setSourceLang(Language.DEMO);
    // correct sentences:
    matches = rule.match(
        srcLangTool.getAnalyzedSentence("This is a test sentence."),
        trgLangTool.getAnalyzedSentence("To zdanie testowe."));
    assertEquals(0, matches.length);
    
    matches = rule.match(
        srcLangTool.getAnalyzedSentence("Click this button."),
        trgLangTool.getAnalyzedSentence("Kliknij ten przycisk."));
    assertEquals(0, matches.length);
    
    // incorrect sentences:
    matches = rule.match(
        srcLangTool.getAnalyzedSentence("Open a file, and check if it is corrupt."),
        trgLangTool.getAnalyzedSentence("Otwórz plik."));
    assertEquals(1, matches.length);
  }

}
