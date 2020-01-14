package com.application.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.application.entity.Bdsk_url;
import com.application.entity.Data;
import com.application.entity.enumeration.DocumentEnum;
import com.application.entity.enumeration.TypeEnum;
import com.application.service.QueryMethodsService;

public abstract class Import {
	public static void importMethode(QueryMethodsService service, String path) throws IOException {
		String file = "";
		file = new String(Files.readString(Path.of(path, new String())));
		
		List<Data> dataToStore = new ArrayList<Data>();
		
		Data data;
		
		//En 2 fois : ^@(\w+){([\w\d]+) (utilisable tel quel) et ([\w\d\-]+) = {(.+) (minus les 2 derniers caractères)
		
		//Gestion de TYPE_BIBLIOGRAPHY et NAME_BIBLIOGRAPHY
		Pattern p = Pattern.compile("@(\\w+)\\{([\\w\\d]+)");
		Matcher m = p.matcher(file);
		while (m.find()) {
			if (!m.group(1).equals("comment")) {
				data = new Data();
				
				data.setTypeBibliography(TypeEnum.valueOf(m.group(1).toUpperCase()));
				data.setNameBibliography(m.group(2));
				
				dataToStore.add(data);
			}
		}
		
		//Gestion des attributs
		p = Pattern.compile("([\\w\\d\\-]+) = \\{(.+)");
		m = p.matcher(file);
		int i = 0;
		data = dataToStore.get(i);
		while (m.find()) {
			
			boolean endOfData = m.group(2).contains("}}");
			String value = m.group(2).substring(0, m.group(2).length() - 2);
			
			if (m.group(1).contains("Bdsk")) {
				if (data.getBdskUrl() == null) {
					data.setBdskUrl(new ArrayList<Bdsk_url>());
				}
				data.getBdskUrl().add(new Bdsk_url(value));
			} else {
				switch (m.group(1).toLowerCase()) {
				case "abstract":
					data.setSummary(value);
					break;
				case "address":
					data.setAddress(value);
					break;
				case "affiliation":
					data.setAffiliation(value);
					break;
				case "article-number":
				case "art_number":
					data.setArticleNumber(value);
					break;
				case "author":
					data.setAuthor(value);
					break;
				case "author-email":
					data.setAuthorEmail(value);
					break;
				case "author_keywords":
					data.setAuthorKeywords(value);
					break;
				case "booktitle":
					data.setBookTitle(value);
					break;
				case "date-added":
					data.setDateAdded(new Date(System.currentTimeMillis()));
					break;
				case "date-modified":
					data.setDateModified(new Date(System.currentTimeMillis()));
					break;
				case "doc-delivery-number":
					data.setDocDeliveryNumber(value);
					break;
				case "document_type":
					switch (value.toLowerCase()) {
						case "conference paper":
							data.setDocumentType(DocumentEnum.CONFERENCE_PAPER);
							break;
						case "article in press":
							data.setDocumentType(DocumentEnum.ARTICLE_IN_PRESS);
							break;
						default:
							data.setDocumentType(DocumentEnum.valueOf(value.toUpperCase()));
							break;
					}
					break;
				case "doi":
					data.setDoi(value);
					break;
				case "editor":
					data.setEditor(value);
					break;
				case "eissn":
					data.setEissn(value);
					break;
				case "funding-acknowledgement":
					data.setFundingAcknowledgement(value);
					break;
//				case "funding-text":
//					data.setFundingText(value);
//					break;
				case "isbn":
					data.setIsbn(value);
					break;
				case "issn":
					data.setIssn(value);
					break;
				case "journal":
					data.setJournal(value);
					break;
				case "journal-iso":
					data.setJournalIso(value);
					break;
				case "keywords":
					data.setKeywords(value);
					break;
				case "keywords-plus":
					data.setKeywordsPlus(value);
					break;
				case "language":
					data.setLanguage(value);
					break;
				case "__markedentry":
					data.setMarkedentry(value);
					break;
				case "month":
					data.setMonth(value);
					break;
				case "note":
					data.setNote(value);
					break;
				case "number":
					data.setNumber(value);
					break;
				case "number-of-cited-references":
					data.setNumberOfCitedReferences(Integer.parseInt(value));
					break;
				case "orcid-numbers":
					data.setOrcidNumbers(value);
					break;
				case "organization":
					data.setOrganization(value);
					break;
				case "page_count":
					data.setPageCount(Integer.parseInt(value));
					break;
				case "pages":
					data.setPages(value);
					break;
				case "publisher":
					data.setPublisher(value);
					break;
				case "research-areas":
					data.setResearchAreas(value);
					break;
				case "researcherid-numbers":
					data.setResearcherIdNumbers(value);
					break;
				case "series":
					data.setSeries(value);
					break;
				case "source":
					data.setSource(value);
					break;
				case "times-cited":
					data.setTimesCited(Integer.parseInt(value));
					break;
				case "title":
					data.setTitle(value);
					break;
				case "to-download":
					if (value.equals("Y")) {
						data.setToDownload(true);
					} else {
						data.setToDownload(false);
					}
					break;
				case "type":
					data.setType(value);
					break;
				case "unique-id":
					data.setUniqueId(value);
					break;
				case "url":
					data.setUrl(value);
					break;
				case "usage-count-last-180-days":
					data.setUsageCountLast180Days(Integer.parseInt(value));
					break;
				case "usage-count-since-2013":
					data.setUsageCountSince_2013(Integer.parseInt(value));
					break;
				case "volume":
					data.setVolume(value);
					break;
				case "web-of-science-categories":
					data.setWebOfScienceCategories(value);
					break;
				case "year":
					data.setYear(Integer.parseInt(value));
					break;
				default:
					System.err.println("Field " + m.group(1) + " not recognized");
					break;
				}
			}
			
			if (endOfData) {
				service.createData(data);
				i++;
				if (i < dataToStore.size()) {
					data = dataToStore.get(i);
				}
			}
		}
	}
	
	public static void exportMethode() {
		
	}
}
