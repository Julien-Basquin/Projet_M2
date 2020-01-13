package com.application.entity;

import java.sql.Date;
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
	private Date dateAdded;
	
	@Column(name = "DATE_MODIFIED")
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

	public Data(String summary, String author, String authorKeywords, Date dateAdded, Date dateModified,
			DocumentEnum documentType, String journal, String note, int number, int pageBegin, int pageEnd,
			String source, String title, String url) {
		this.summary = summary;
		this.author = author;
		this.authorKeywords = authorKeywords;
		this.dateAdded = dateAdded;
		this.dateModified = dateModified;
		this.documentType = documentType;
		this.journal = journal;
		this.note = note;
		this.number = number;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.source = source;
		this.title = title;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorKeywords() {
		return authorKeywords;
	}

	public void setAuthorKeywords(String authorKeywords) {
		this.authorKeywords = authorKeywords;
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

	public DocumentEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentEnum documentType) {
		this.documentType = documentType;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getBdskUrl() {
		return bdskUrl;
	}

	public void setBdskUrl(List<String> bdskUrl) {
		this.bdskUrl = bdskUrl;
	}
}
