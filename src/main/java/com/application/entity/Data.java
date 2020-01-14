package com.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.application.entity.enumeration.DocumentEnum;
import com.application.entity.enumeration.TypeEnum;

@Entity 
@Table(name = "DATA")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "TYPE_BIBLIOGRAPHY", nullable = false)
	private TypeEnum typeBibliography;
	
	@Column(name = "NAME_BIBLIOGRAPHY", nullable = false)
	private String nameBibliography;
	
	@Column(name = "ABSTRACT", length = 4096)
	private String summary;
	
	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "AFFILIATION")
	private String affiliation;
	
	@Column(name = "ARTICLE_NUMBER")
	private String articleNumber;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;
	
	@Column(name = "AUTHOR_KEYWORDS")
	private String authorKeywords;

	@Column(name = "BDSK_URL")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Bdsk_url.class)
	private List<String> bdskUrl;
	
	@Column(name = "BOOK_TITLE")
	private String bookTitle;
	
	@Column(name = "DATE_ADDED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	
	@Column(name = "DATE_MODIFIED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;
	
	@Column(name = "DOC_DELIVERY_NUMBER")
	private String docDeliveryNumber;
	
	@Column(name = "DOCUMENT_TYPE", nullable = false)
	private DocumentEnum documentType;
	
	@Column(name = "DOI")
	private String doi;
	
	@Column(name = "EISSN")
	private String eissn;
	
	@Column(name = "ISSN")
	private String issn;
	
	@Column(name = "JOURNAL")
	private String journal;
	
	@Column(name = "JOURNAL_ISO")
	private String journalIso;
	
	@Column(name = "KEYWORDS")
	private String keywords;
	
	@Column(name = "KEYWORDS_PLUS")
	private String keywordsPlus;
	
	@Column(name = "LANGUAGE")
	private String language;
	
	@Column(name = "MARKEDENTRY")
	private String markedentry;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "NOTE")
	private String note;
	
	@Column(name = "NUMBER")
	private int number;
	
	@Column(name = "NUMBER_OF_CITED_REFERENCES")
	private int numberOfCitedReferences;
	
	@Column(name = "ORCID_NUMBERS")
	private String orcidNumbers;
	
	@Column(name = "PAGE_BEGIN")
	private int pageBegin;
	
	@Column(name = "PAGE_END")
	private int pageEnd;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@Column(name = "RESEARCH_AREAS")
	private String researchAreas;
	
	@Column(name = "RESEARCH_ID_NUMBERS")
	private String researchIdNumbers;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "TIME_CITED")
	private int timeCited;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "TO_DOWNLOAD")
	private boolean toDownload;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "UNIQUE_ID")
	private String uniqueId;
	
	@Column(name = "URL")
	private String url;

	@Column(name = "USAGE_COUNT_LAST_180_DAYS")
	private int usageCountLast180Days;
	
	@Column(name = "USAGE_COUNT_SINCE_2013")
	private int usageCountSince_2013;
	
	@Column(name = "VOLUME")
	private String volume;
	
	@Column(name = "WEB_OF_SCIENCE_CATEGORIES")
	private String webOfScienceCategories;
	
	@Column(name = "YEAR")
	private int year;

	public Data() {}

	public Data(Long id, TypeEnum typeBibliography, String nameBibliography, String summary, String address,
			String affiliation, String articleNumber, String author, String authorEmail, String authorKeywords, 
			String bookTitle, Date dateAdded, Date dateModified, String docDeliveryNumber,
			DocumentEnum documentType, String doi, String eissn, String issn, String journal, String journalIso,
			String keywords, String keywordsPlus, String language, String markedentry, String month, String note,
			int number, int numberOfCitedReferences, String orcidNumbers, int pageBegin, int pageEnd, String publisher,
			String researchAreas, String researchIdNumbers, String source, int timeCited, String title,
			boolean toDownload, String type, String uniqueId, String url, int usageCountLast180Days,
			int usageCountSince_2013, String volume, String webOfScienceCategories, int year) {
		this.id = id;
		this.typeBibliography = typeBibliography;
		this.nameBibliography = nameBibliography;
		this.summary = summary;
		this.address = address;
		this.affiliation = affiliation;
		this.articleNumber = articleNumber;
		this.author = author;
		this.authorEmail = authorEmail;
		this.authorKeywords = authorKeywords;
		this.bookTitle = bookTitle;
		this.dateAdded = dateAdded;
		this.dateModified = dateModified;
		this.docDeliveryNumber = docDeliveryNumber;
		this.documentType = documentType;
		this.doi = doi;
		this.eissn = eissn;
		this.issn = issn;
		this.journal = journal;
		this.journalIso = journalIso;
		this.keywords = keywords;
		this.keywordsPlus = keywordsPlus;
		this.language = language;
		this.markedentry = markedentry;
		this.month = month;
		this.note = note;
		this.number = number;
		this.numberOfCitedReferences = numberOfCitedReferences;
		this.orcidNumbers = orcidNumbers;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.publisher = publisher;
		this.researchAreas = researchAreas;
		this.researchIdNumbers = researchIdNumbers;
		this.source = source;
		this.timeCited = timeCited;
		this.title = title;
		this.toDownload = toDownload;
		this.type = type;
		this.uniqueId = uniqueId;
		this.url = url;
		this.usageCountLast180Days = usageCountLast180Days;
		this.usageCountSince_2013 = usageCountSince_2013;
		this.volume = volume;
		this.webOfScienceCategories = webOfScienceCategories;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeEnum getTypeBibliography() {
		return typeBibliography;
	}

	public void setTypeBibliography(TypeEnum typeBibliography) {
		this.typeBibliography = typeBibliography;
	}

	public String getNameBibliography() {
		return nameBibliography;
	}

	public void setNameBibliography(String nameBibliography) {
		this.nameBibliography = nameBibliography;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getAuthorKeywords() {
		return authorKeywords;
	}

	public void setAuthorKeywords(String authorKeywords) {
		this.authorKeywords = authorKeywords;
	}

	public List<String> getBdskUrl() {
		return bdskUrl;
	}

	public void setBdskUrl(List<String> bdskUrl) {
		this.bdskUrl = bdskUrl;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getDocDeliveryNumber() {
		return docDeliveryNumber;
	}

	public void setDocDeliveryNumber(String docDeliveryNumber) {
		this.docDeliveryNumber = docDeliveryNumber;
	}

	public DocumentEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentEnum documentType) {
		this.documentType = documentType;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getEissn() {
		return eissn;
	}

	public void setEissn(String eissn) {
		this.eissn = eissn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getJournalIso() {
		return journalIso;
	}

	public void setJournalIso(String journalIso) {
		this.journalIso = journalIso;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywordsPlus() {
		return keywordsPlus;
	}

	public void setKeywordsPlus(String keywordsPlus) {
		this.keywordsPlus = keywordsPlus;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMarkedentry() {
		return markedentry;
	}

	public void setMarkedentry(String markedentry) {
		this.markedentry = markedentry;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumberOfCitedReferences() {
		return numberOfCitedReferences;
	}

	public void setNumberOfCitedReferences(int numberOfCitedReferences) {
		this.numberOfCitedReferences = numberOfCitedReferences;
	}

	public String getOrcidNumbers() {
		return orcidNumbers;
	}

	public void setOrcidNumbers(String orcidNumbers) {
		this.orcidNumbers = orcidNumbers;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getResearchAreas() {
		return researchAreas;
	}

	public void setResearchAreas(String researchAreas) {
		this.researchAreas = researchAreas;
	}

	public String getResearchIdNumbers() {
		return researchIdNumbers;
	}

	public void setResearchIdNumbers(String researchIdNumbers) {
		this.researchIdNumbers = researchIdNumbers;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getTimeCited() {
		return timeCited;
	}

	public void setTimeCited(int timeCited) {
		this.timeCited = timeCited;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isToDownload() {
		return toDownload;
	}

	public void setToDownload(boolean toDownload) {
		this.toDownload = toDownload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUsageCountLast180Days() {
		return usageCountLast180Days;
	}

	public void setUsageCountLast180Days(int usageCountLast180Days) {
		this.usageCountLast180Days = usageCountLast180Days;
	}

	public int getUsageCountSince_2013() {
		return usageCountSince_2013;
	}

	public void setUsageCountSince_2013(int usageCountSince_2013) {
		this.usageCountSince_2013 = usageCountSince_2013;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getWebOfScienceCategories() {
		return webOfScienceCategories;
	}

	public void setWebOfScienceCategories(String webOfScienceCategories) {
		this.webOfScienceCategories = webOfScienceCategories;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return id + " " + typeBibliography.name() + " " + nameBibliography;
	}
}
