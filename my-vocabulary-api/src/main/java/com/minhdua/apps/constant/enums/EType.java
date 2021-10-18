package com.minhdua.apps.constant.enums;

import com.minhdua.apps.document.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EType {
	CC(Type.builder().fullName("coordinating conjunction").shortName("CC").example("and").build()),
	CD(Type.builder().fullName("cardinal number").shortName("CD").example("1, third").build()),
	DT(Type.builder().fullName("determiner").shortName("DT").example("the").build()),
	EX(Type.builder().fullName("existential there").shortName("EX").example("there is").build()),
	FW(Type.builder().fullName("foreign word").shortName("FW").example("les").build()),
	IN(Type.builder().fullName("preposition, subordinating conjunction").shortName("IN").example("in, of, like")
			.build()),
	IN_THAT(Type.builder().fullName("that as subordinator").shortName("IN/THAT").example("that").build()),
	JJ(Type.builder().fullName("adjective").shortName("JJ").example("green").build()),
	JJR(Type.builder().fullName("adjective, comparative").shortName("JJR").example("greener").build()),
	JJS(Type.builder().fullName("adjective, superlative").shortName("JJS").example("greenest").build()),
	LS(Type.builder().fullName("list marker").shortName("LS").example("1)").build()),
	MD(Type.builder().fullName("modal").shortName("MD").example("could, will").build()),
	NN(Type.builder().fullName("noun, singular or mass").shortName("NN").example("table").build()),
	NNS(Type.builder().fullName("noun plural").shortName("NNS").example("tables").build()),
	NP(Type.builder().fullName("proper noun, singular").shortName("NP").example("John").build()),
	NPS(Type.builder().fullName("proper noun, plural").shortName("NPS").example("Vikings").build()),
	PDT(Type.builder().fullName("predeterminer").shortName("PDT").example("both the boys").build()),
	POS(Type.builder().fullName("possessive ending").shortName("POS").example("friend’s").build()),
	PP(Type.builder().fullName("personal pronoun").shortName("PP").example("I, he, it").build()),
	PPZ(Type.builder().fullName("possessive pronoun").shortName("PPZ").example("my, his").build()),
	RB(Type.builder().fullName("adverb").shortName("RB").example("however, usually, naturally, here, good").build()),
	RBR(Type.builder().fullName("adverb, comparative").shortName("RBR").example("better").build()),
	RBS(Type.builder().fullName("adverb, superlative").shortName("RBS").example("best").build()),
	RP(Type.builder().fullName("particle").shortName("RP").example("give up").build()),
	SENT(Type.builder().fullName("Sentence-break punctuation").shortName("SENT").example(". ! ?").build()),
	SYM(Type.builder().fullName("Symbol").shortName("SYM").example("/ [ = *").build()),
	TO(Type.builder().fullName("infinitive ‘to’").shortName("TO").example("togo").build()),
	UH(Type.builder().fullName("interjection").shortName("UH").example("uhhuhhuhh").build()),
	VB(Type.builder().fullName("verb be, base form").shortName("VB").example("be").build()),
	VBD(Type.builder().fullName("verb be, past tense").shortName("VBD").example("was, were").build()),
	VBG(Type.builder().fullName("verb be, gerund/present participle").shortName("VBG").example("being").build()),
	VBN(Type.builder().fullName("verb be, past participle").shortName("VBN").example("been").build()),
	VBP(Type.builder().fullName("verb be, sing. present, non-3d").shortName("VBP").example("am, are").build()),
	VBZ(Type.builder().fullName("verb be, 3rd person sing. present").shortName("VBZ").example("is").build()),
	VH(Type.builder().fullName("verb have, base form").shortName("VH").example("have").build()),
	VHD(Type.builder().fullName("verb have, past tense").shortName("VHD").example("had").build()),
	VHG(Type.builder().fullName("verb have, gerund/present participle").shortName("VHG").example("having").build()),
	VHN(Type.builder().fullName("verb have, past participle").shortName("VHN").example("had").build()),
	VHP(Type.builder().fullName("verb have, sing. present, non-3d").shortName("VHP").example("have").build()),
	VHZ(Type.builder().fullName("verb have, 3rd person sing. present").shortName("VHZ").example("has").build()),
	VV(Type.builder().fullName("verb, base form").shortName("VV").example("take").build()),
	VVD(Type.builder().fullName("verb, past tense").shortName("VVD").example("took").build()),
	VVG(Type.builder().fullName("verb, gerund/present participle").shortName("VVG").example("taking").build()),
	VVN(Type.builder().fullName("verb, past participle").shortName("VVN").example("taken").build()),
	VVP(Type.builder().fullName("verb, sing. present, non-3d").shortName("VVP").example("take").build()),
	VVZ(Type.builder().fullName("verb, 3rd person sing. present").shortName("VVZ").example("takes").build()),
	WDT(Type.builder().fullName("wh-determiner").shortName("WDT").example("which").build()),
	WP(Type.builder().fullName("wh-pronoun").shortName("WP").example("who, what").build()),
	WP2(Type.builder().fullName("possessive wh-pronoun").shortName("WP$").example("whose").build()),
	WRB(Type.builder().fullName("wh-abverb").shortName("WRB").example("where, when").build()),
	DOLLAR_SIGN(Type.builder().fullName("$").shortName("$").example("$").build()),
	OCTOTHORPE(Type.builder().fullName("#").shortName("#").example("#").build()),
	QUOTE(Type.builder().fullName("Quotation marks").shortName("“").example("‘ “").build()),
	ACUTE_DOUBLE(Type.builder().fullName("Opening quotation marks").shortName("``").example("‘ “").build()),
	OPEN_OR_LEFT_PARENTHESIS(Type.builder().fullName("Opening brackets").shortName("(").example("( {").build()),
	CLOSE_OR_RIGHT_PARENTHESIS(Type.builder().fullName("Closing brackets").shortName(")").example(") }").build()),
	COMMA(Type.builder().fullName("Comma").shortName(",").example(",").build()),
	COLON(Type.builder().fullName("Punctuation").shortName(":").example("– ; : — …").build());

	private Type type;
}