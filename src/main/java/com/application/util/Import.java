package com.application.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.application.dao.BdskUrlRepository;
import com.application.entity.Bdsk_url;
import com.application.entity.Data;
import com.application.service.QueryMethodsService;

public abstract class Import {
	public static void importMethode(QueryMethodsService service, String path) throws IOException {
		String file = "";
		file = new String(Files.readString(Path.of(path, new String())));
		
		List<Data> dataToStore = new ArrayList<Data>();
		Data data;
		
		//Gestion de TYPE_BIBLIOGRAPHY et NAME_BIBLIOGRAPHY
		Pattern p = Pattern.compile("@(\\w+)\\{([\\w\\d]+)");
		Matcher m = p.matcher(file);
		while (m.find()) {
			if (!m.group(1).equals("comment")) {
				data = new Data();
				
				data.setTypeBibliography(m.group(1));
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
					data.setDocumentType(value);
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
				case "funding-text":
					data.setFundingText(value);
					break;
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
					data.setUsageCountSince2013(Integer.parseInt(value));
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
			
			//Fin de l'article, enregistrement en base
			if (endOfData) {
				service.createData(data);
				i++;
				if (i < dataToStore.size()) {
					data = dataToStore.get(i);
				}
			}
		}
	}
	
	public static void exportMethode(QueryMethodsService service, BdskUrlRepository bdskRepository) {
		exportMethode(service, bdskRepository, "FROM DATA", "");
	}
	
	public static void exportMethode(QueryMethodsService service, BdskUrlRepository bdskRepository, String from, String options) {
		File export = new File("export.txt");
		
		//Création d'un nouveau fichier si l'export existe déjà
		int i = 1;
		while (export.exists()) {
			export.renameTo(new File("export" + i + ".txt"));
			i++;
		}
		
		try {
			FileWriter writer  = new FileWriter(export);
			
			String select = "select ";
			//Ajout de la table data au from si pas déjà présente
			Pattern p = Pattern.compile("(data)( \\w+)?", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(from);
			if (!m.find()) {
				select += "data.*";
				if (from.isEmpty()) {
					from = "data";
				} else {
					from += ", data";
				}
			} else {
				if (m.group(2) != null) {
					select += m.group(2) + ".*";
				} else {
					select += "data.*";
				}
			}
			
			List<Data> data = service.executeQuery(select + " " + from + " " + options);
			Field[] fields = Data.class.getDeclaredFields();
			
			for (Data d : data) {
				writer.write("@" + d.getTypeBibliography() + "{" + d.getNameBibliography() + ",\n");
				
				if (d.getMarkedentry() != null) {
					writer.write("\t__Markedentry = {" + d.getMarkedentry() + "},\n");
				}
				for (Field field : fields) {
					switch (field.getName()) {
						case "id":
						case "typeBibliography":
						case "nameBibliography":
						case "markedentry":
							continue;
						case "bdskUrl":
							break;
						case "summary":
							if (d.getSummary() != null) {
								writer.write("\tAbstract = {" + d.getSummary() + "}");
							}
							break;
						case "address":
							if (d.getAddress() != null) {
								writer.write(",\n\tAddress = {" + d.getAddress() + "}");
							}
							break;
						case "affiliation":
							if (d.getAffiliation() != null) {
								writer.write(",\n\tAffiliation = {" + d.getAffiliation() + "}");
							}
							break;
						case "articleNumber":
							if (d.getArticleNumber() != null) {
								writer.write(",\n\tArt_Number = {" + d.getArticleNumber() + "}");
							}
							break;
						case "author":
							if (d.getAuthor() != null) {
								writer.write(",\n\tAuthor = {" + d.getAuthor() + "}");
							}
							break;
						case "authorEmail":
							if (d.getAuthorEmail() != null) {
								writer.write(",\n\tAuthor-Email = {" + d.getAuthorEmail() + "}");
							}
							break;
						case "authorKeywords":
							if (d.getAuthorKeywords() != null) {
								writer.write(",\n\tAuthor_Keywords = {" + d.getAuthorKeywords() + "}");
							}
							break;
						case "bookTitle":
							if (d.getBookTitle() != null) {
								writer.write(",\n\tBooktitle = {" + d.getBookTitle() + "}");
							}
							break;
						case "dateAdded":
							writer.write(",\n\tDate-Added = {" + d.getDateAdded() + "}");
							break;
						case "dateModified":
							writer.write(",\n\tDate-Modified = {" + d.getDateModified() + "}");
							break;
						case "docDeliveryNumber":
							if (d.getDocDeliveryNumber() != null) {
								writer.write(",\n\tDoc-Delivery-Number = {" + d.getDocDeliveryNumber() + "}");
							}
							break;
						case "documentType":
							if (d.getDocumentType() != null) {
								writer.write(",\n\tDocument_Type = {" + d.getDocumentType() + "}");
							}
							break;
						case "doi":
							if (d.getDoi() != null) {
								writer.write(",\n\tDoi = {" + d.getDoi() + "}");
							}
							break;
						case "editor":
							if (d.getEditor() != null) {
								writer.write(",\n\tEditor = {" + d.getEditor() + "}");
							}
							break;
						case "eissn":
							if (d.getEissn() != null) {
								writer.write(",\n\tEissn = {" + d.getEissn() + "}");
							}
							break;
						case "fundingAcknowledgement":
							if (d.getFundingAcknowledgement() != null) {
								writer.write(",\n\tFunding-Acknowledgement = {" + d.getFundingAcknowledgement() + "}");
							}
							break;
						case "fundingText":
							if (d.getFundingText() != null) {
								writer.write(",\n\tFunding-Text = {" + d.getFundingText() + "}");
							}
							break;
						case "isbn":
							if (d.getIsbn() != null) {
								writer.write(",\n\tIsbn = {" + d.getIsbn() + "}");
							}
							break;
						case "issn":
							if (d.getIssn() != null) {
								writer.write(",\n\tIssn = {" + d.getIssn() + "}");
							}
							break;
						case "journal":
							if (d.getJournal() != null) {
								writer.write(",\n\tJournal = {" + d.getJournal() + "}");
							}
							break;
						case "journalIso":
							if (d.getJournalIso() != null) {
								writer.write(",\n\tJournal-Iso= {" + d.getJournalIso() + "}");
							}
							break;
						case "keywords":
							if (d.getKeywords() != null) {
								writer.write(",\n\tKeywords = {" + d.getKeywords() + "}");
							}
							break;
						case "keywordsPlus":
							if (d.getKeywordsPlus() != null) {
								writer.write(",\n\tKeywords-Plus = {" + d.getKeywordsPlus() + "}");
							}
							break;
						case "language":
							if (d.getLanguage() != null) {
								writer.write(",\n\tLanguage = {" + d.getLanguage() + "}");
							}
							break;
						case "month":
							if (d.getMonth() != null) {
								writer.write(",\n\tMonth = {" + d.getMonth() + "}");
							}
							break;
						case "note":
							if (d.getNote() != null) {
								writer.write(",\n\tNote = {" + d.getNote() + "}");
							}
							break;
						case "number":
							if (d.getNumber() != null) {
								writer.write(",\n\tNumber = {" + d.getNumber() + "}");
							}
							break;
						case "numberOfCitedReferences":
							if (d.getNumberOfCitedReferences() != 0) {
								writer.write(",\n\tNumber-Of-Cited-References = {" + d.getNumberOfCitedReferences() + "}");
							}
							break;
						case "orcidNumbers":
							if (d.getOrcidNumbers() != null) {
								writer.write(",\n\tOrcid-Numbers = {" + d.getOrcidNumbers() + "}");
							}
							break;
						case "organization":
							if (d.getOrganization() != null) {
								writer.write(",\n\tOrganization = {" + d.getOrganization() + "}");
							}
							break;
						case "pageCount":
							if (d.getPageCount() != 0) {
								writer.write(",\n\tPage_Count = {" + d.getPageCount() + "}");
							}
							break;
						case "pages":
							if (d.getPages() != null) {
								writer.write(",\n\tPages = {" + d.getPages() + "}");
							}
							break;
						case "publisher":
							if (d.getPublisher() != null) {
								writer.write(",\n\tPublisher = {" + d.getPublisher() + "}");
							}
							break;
						case "researchAreas":
							if (d.getResearchAreas() != null) {
								writer.write(",\n\tResearch-Areas = {" + d.getResearchAreas() + "}");
							}
							break;
						case "researcherIdNumbers":
							if (d.getResearcherIdNumbers() != null) {
								writer.write(",\n\tResearcherid-Numbers = {" + d.getResearcherIdNumbers() + "}");
							}
							break;
						case "series":
							if (d.getSeries() != null) {
								writer.write(",\n\tSeries = {" + d.getSeries() + "}");
							}
							break;
						case "source":
							if (d.getSource() != null) {
								writer.write(",\n\tSource = {" + d.getSource() + "}");
							}
							break;
						case "timesCited":
							if (d.getTimesCited() != 0) {
								writer.write(",\n\tTimes-Cited = {" + d.getTimesCited() + "}");
							}
							break;
						case "title":
							if (d.getTitle() != null) {
								writer.write(",\n\tTitle = {" + d.getTitle() + "}");
							}
							break;
						case "toDownload":
							if (d.isToDownload()) {
								writer.write(",\n\tTo-Download = {Y}");
							}
							break;
						case "type":
							if (d.getType() != null) {
								writer.write(",\n\tType = {" + d.getType() + "}");
							}
							break;
						case "uniqueId":
							if (d.getUniqueId() != null) {
								writer.write(",\n\tUnique-Id = {" + d.getUniqueId() + "}");
							}
							break;
						case "url":
							if (d.getUrl() != null) {
								writer.write(",\n\tUrl = {" + d.getUrl() + "}");
							}
							break;
						case "usageCountLast180Days":
							if (d.getUsageCountLast180Days() != 0) {
								writer.write(",\n\tUsage-Count-Last-180-Days = {" + d.getUsageCountLast180Days() + "}");
							}
							break;
						case "usageCountSince2013":
							if (d.getUsageCountSince2013() != 0) {
								writer.write(",\n\tUsage-Count-Since-2013 = {" + d.getUsageCountSince2013() + "}");
							}
							break;
						case "volume":
							if (d.getVolume() != null) {
								writer.write(",\n\tVolume = {" + d.getVolume() + "}");
							}
							break;
						case "webOfScienceCategories":
							if (d.getWebOfScienceCategories() != null) {
								writer.write(",\n\tWeb-Of-Science-Categories = {" + d.getWebOfScienceCategories() + "}");
							}
							break;
						case "year":
							if (d.getYear() != 0) {
								writer.write(",\n\tYear = {" + d.getYear() + "}");
							}
							break;
						default:
							System.err.println("Field " + field.getName() + " not recognized");
							break;
					}
				}
				
				for (int j = 0; j < d.getBdskUrl().size(); j++) {
					Optional<Bdsk_url> bdsk = bdskRepository.findById(d.getBdskUrl().get(j).getId());
					if (bdsk.isPresent()) {
						writer.write(",\n\tBdsk-Url-" + (j + 1) + " = {"+ bdsk.get().getUrl() + "}");
					}
				}

				writer.write("}\n\n");
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
