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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "DATA")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "TYPE_BIBLIOGRAPHY", nullable = false)
	private String typeBibliography;
	
	@Column(name = "NAME_BIBLIOGRAPHY", nullable = false)
	private String nameBibliography;
	
	@Lob
	@Column(name = "ABSTRACT")
	private String summary;
	
	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "AFFILIATION", length = 2048)
	private String affiliation;
	
	@Column(name = "ARTICLE_NUMBER")
	private String articleNumber;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;
	
	@Lob
	@Column(name = "AUTHOR_KEYWORDS")
	private String authorKeywords;

	@Column(name = "BDSK_URL")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Bdsk_url.class)
	private List<Bdsk_url> bdskUrl;
	
	@Column(name = "BOOK_TITLE")
	private String bookTitle;
	
	@Column(name = "DATE_ADDED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdded;
	
	@Column(name = "DATE_MODIFIED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;
	
	@Column(name = "DOC_DELIVERY_NUMBER")
	private String docDeliveryNumber;
	
	@Column(name = "DOCUMENT_TYPE")
	private String documentType;
	
	@Column(name = "DOI")
	private String doi;
	
	@Column(name = "EDITOR")
	private String editor;
	
	@Column(name = "EISSN")
	private String eissn;
	
	@Column(name = "FUNDING_ACKNOWLEDGEMENT")
	private String fundingAcknowledgement;
	
	@Lob
	@Column(name = "FUNDING_TEXT", length = 2048)
	private String fundingText;
	
	@Column(name = "ISNB")
	private String isbn;
	
	@Column(name = "ISSN")
	private String issn;
	
	@Lob
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
	private String number;
	
	@Column(name = "NUMBER_OF_CITED_REFERENCES")
	private int numberOfCitedReferences;
	
	@Column(name = "ORCID_NUMBERS")
	private String orcidNumbers;
	
	@Column(name = "ORGANIZATION")
	private String organization;
	
	@Column(name = "PAGE_COUNT")
	private int pageCount;
	
	@Column(name = "PAGES")
	private String pages;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@Column(name = "RESEARCH_AREAS")
	private String researchAreas;
	
	@Column(name = "RESEARCHER_ID_NUMBERS")
	private String researcherIdNumbers;
	
	@Column(name = "SERIES")
	private String series;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "TIMES_CITED")
	private int timesCited;
	
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
	private int usageCountSince2013;
	
	@Column(name = "VOLUME")
	private String volume;
	
	@Column(name = "WEB_OF_SCIENCE_CATEGORIES")
	private String webOfScienceCategories;
	
	@Column(name = "YEAR")
	private int year;

	public Data() {}

	public Data(String typeBibliography, String nameBibliography, String summary, String address, String affiliation,
			String articleNumber, String author, String authorEmail, String authorKeywords, String bookTitle,
			Date dateAdded, Date dateModified, String docDeliveryNumber, String documentType, String doi,
			String editor, String eissn, String fundingAcknowledgement, String fundingText, String isbn, String issn,
			String journal, String journalIso, String keywords, String keywordsPlus, String language,
			String markedentry, String month, String note, String number, int numberOfCitedReferences,
			String orcidNumbers, String organization, int pageCount, String pages, String publisher,
			String researchAreas, String researcherIdNumbers, String series, String source, int timesCited,
			String title, boolean toDownload, String type, String uniqueId, String url, int usageCountLast180Days,
			int usageCountSince2013, String volume, String webOfScienceCategories, int year) {
		super();
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
		this.editor = editor;
		this.eissn = eissn;
		this.fundingAcknowledgement = fundingAcknowledgement;
//		this.fundingText = fundingText;
		this.isbn = isbn;
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
		this.organization = organization;
		this.pageCount = pageCount;
		this.pages = pages;
		this.publisher = publisher;
		this.researchAreas = researchAreas;
		this.researcherIdNumbers = researcherIdNumbers;
		this.series = series;
		this.source = source;
		this.timesCited = timesCited;
		this.title = title;
		this.toDownload = toDownload;
		this.type = type;
		this.uniqueId = uniqueId;
		this.url = url;
		this.usageCountLast180Days = usageCountLast180Days;
		this.usageCountSince2013 = usageCountSince2013;
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

	public String getTypeBibliography() {
		return typeBibliography;
	}

	public void setTypeBibliography(String typeBibliography) {
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

	public List<Bdsk_url> getBdskUrl() {
		return bdskUrl;
	}

	public void setBdskUrl(List<Bdsk_url> bdskUrl) {
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

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getEissn() {
		return eissn;
	}

	public void setEissn(String eissn) {
		this.eissn = eissn;
	}

	public String getFundingAcknowledgement() {
		return fundingAcknowledgement;
	}

	public void setFundingAcknowledgement(String fundingAcknowledgement) {
		this.fundingAcknowledgement = fundingAcknowledgement;
	}

	public String getFundingText() {
		return fundingText;
	}

	public void setFundingText(String fundingText) {
		this.fundingText = fundingText;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
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

	public String getResearcherIdNumbers() {
		return researcherIdNumbers;
	}

	public void setResearcherIdNumbers(String researcherIdNumbers) {
		this.researcherIdNumbers = researcherIdNumbers;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getTimesCited() {
		return timesCited;
	}

	public void setTimesCited(int timesCited) {
		this.timesCited = timesCited;
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

	public int getUsageCountSince2013() {
		return usageCountSince2013;
	}

	public void setUsageCountSince2013(int usageCountSince2013) {
		this.usageCountSince2013 = usageCountSince2013;
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
		return id + " " + typeBibliography + " " + nameBibliography;
	}

	@Override
	public boolean equals(Object obj) {
		return id == ((Data) obj).getId();
	}
}
