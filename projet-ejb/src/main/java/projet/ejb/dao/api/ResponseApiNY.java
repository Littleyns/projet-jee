package projet.ejb.dao.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ResponseApiNY {
    private String status;
    private String copyright;
    private int num_results;
    private String last_modified;
    private Results results;

    // Getters and setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Results {
        public String getList_name() {
			return list_name;
		}

		public String getList_name_encoded() {
			return list_name_encoded;
		}

		public String getBestsellers_date() {
			return bestsellers_date;
		}

		public String getPublished_date() {
			return published_date;
		}

		public String getPublished_date_description() {
			return published_date_description;
		}

		public String getNext_published_date() {
			return next_published_date;
		}

		public String getPrevious_published_date() {
			return previous_published_date;
		}

		public String getDisplay_name() {
			return display_name;
		}

		public int getNormal_list_ends_at() {
			return normal_list_ends_at;
		}

		public String getUpdated() {
			return updated;
		}

		private String list_name;
        private String list_name_encoded;
        private String bestsellers_date;
        private String published_date;
        private String published_date_description;
        private String next_published_date;
        private String previous_published_date;
        private String display_name;
        private int normal_list_ends_at;
        private String updated;
        private List<Book> books;

        // Getters and setters

        // ... (getter and setter methods for other properties)

        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }

    // Inner class for "books"

    public static class Book {
        private int rank;
        private int rank_last_week;
        private int weeks_on_list;
        private int asterisk;
        private int dagger;
        private String primary_isbn10;
        private String primary_isbn13;
        private String publisher;
        private String description;
        private String price;
        private String title;
        private String author;
        private String contributor;
        private String contributor_note;
		private String book_image;
        private int book_image_width;
        private int book_image_height;
        private String amazon_product_url;
        private String age_group;
        private String book_review_link;
        private String first_chapter_link;
        private String sunday_review_link;
        private String article_chapter_link;
        private List<Isbn> isbns;
        private List<BuyLink> buy_links;
        private String book_uri;
		public int getRank() {
			return rank;
		}
		public int getRank_last_week() {
			return rank_last_week;
		}
		public int getWeeks_on_list() {
			return weeks_on_list;
		}
		public int getAsterisk() {
			return asterisk;
		}
		public int getDagger() {
			return dagger;
		}
		public String getPrimary_isbn10() {
			return primary_isbn10;
		}
		public String getPrimary_isbn13() {
			return primary_isbn13;
		}
		public String getPublisher() {
			return publisher;
		}
		public String getDescription() {
			return description;
		}
		public String getPrice() {
			return price;
		}
		public String getTitle() {
			return title;
		}
		public String getAuthor() {
			return author;
		}
		public String getContributor() {
			return contributor;
		}
		public String getContributor_note() {
			return contributor_note;
		}
		public String getBook_image() {
			return book_image;
		}
		public int getBook_image_width() {
			return book_image_width;
		}
		public int getBook_image_height() {
			return book_image_height;
		}
		public String getAmazon_product_url() {
			return amazon_product_url;
		}
		public String getAge_group() {
			return age_group;
		}
		public String getBook_review_link() {
			return book_review_link;
		}
		public String getFirst_chapter_link() {
			return first_chapter_link;
		}
		public String getSunday_review_link() {
			return sunday_review_link;
		}
		public String getArticle_chapter_link() {
			return article_chapter_link;
		}
		public List<Isbn> getIsbns() {
			return isbns;
		}
		public List<BuyLink> getBuy_links() {
			return buy_links;
		}
		public String getBook_uri() {
			return book_uri;
		}

    
        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Isbn {
        private String isbn10;
        private String isbn13;
		public String getIsbn10() {
			return isbn10;
		}
		public void setIsbn10(String isbn10) {
			this.isbn10 = isbn10;
		}
		public String getIsbn13() {
			return isbn13;
		}
		public void setIsbn13(String isbn13) {
			this.isbn13 = isbn13;
		}

        // Getters and setters

        // ... (getter and setter methods)
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BuyLink {
        private String name;
        private String url;
		public String getName() {
			return name;
		}
		public String getUrl() {
			return url;
		}

        // Getters and setters

        // ... (getter and setter methods)
    }
}