package projet.ejb.dao.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseApiGGL {
    private String kind;
    private int totalItems;
    private Item[] items;


    public String getKind() {
		return kind;
	}


	public int getTotalItems() {
		return totalItems;
	}


	public Item[] getItems() {
		return items;
	}

    @JsonIgnoreProperties(ignoreUnknown = true)
	public static class Item {
        private String kind;
        private String id;
        private String etag;
        private String selfLink;
        private Book volumeInfo;
        private SaleInfo saleInfo;
        private AccessInfo accessInfo;
        private SearchInfo searchInfo;

        // Getters and setters

        public String getKind() {
			return kind;
		}

		public void setKind(String kind) {
			this.kind = kind;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEtag() {
			return etag;
		}

		public void setEtag(String etag) {
			this.etag = etag;
		}

		public String getSelfLink() {
			return selfLink;
		}

		public void setSelfLink(String selfLink) {
			this.selfLink = selfLink;
		}

		public Book getVolumeInfo() {
			return volumeInfo;
		}

		public void setVolumeInfo(Book volumeInfo) {
			this.volumeInfo = volumeInfo;
		}

		public SaleInfo getSaleInfo() {
			return saleInfo;
		}

		public void setSaleInfo(SaleInfo saleInfo) {
			this.saleInfo = saleInfo;
		}

		public AccessInfo getAccessInfo() {
			return accessInfo;
		}

		public void setAccessInfo(AccessInfo accessInfo) {
			this.accessInfo = accessInfo;
		}

		public SearchInfo getSearchInfo() {
			return searchInfo;
		}

		public void setSearchInfo(SearchInfo searchInfo) {
			this.searchInfo = searchInfo;
		}
	    @JsonIgnoreProperties(ignoreUnknown = true)
		public static class Book {
            private String title;
            private String[] authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private IndustryIdentifier[] industryIdentifiers;
            private ReadingModes readingModes;
            private int pageCount;
            private String printType;
            private String[] categories;
            private int averageRating;
            private int ratingsCount;
            private String maturityRating;
            private boolean allowAnonLogging;
            private String contentVersion;
            private PanelizationSummary panelizationSummary;
            private boolean comicsContent;
            private ImageLinks imageLinks;
            private String language;
            private String previewLink;
            private String infoLink;
            private String canonicalVolumeLink;
            
            // Getters and setters

            public String getTitle() {
				return title;
			}

			public String[] getAuthors() {
				return authors;
			}

			public String getPublisher() {
				return publisher;
			}

			public String getPublishedDate() {
				return publishedDate;
			}

			public String getDescription() {
				return description;
			}

			public IndustryIdentifier[] getIndustryIdentifiers() {
				return industryIdentifiers;
			}

			public ReadingModes getReadingModes() {
				return readingModes;
			}

			public int getPageCount() {
				return pageCount;
			}

			public String getPrintType() {
				return printType;
			}

			public String[] getCategories() {
				return categories;
			}

			public int getAverageRating() {
				return averageRating;
			}

			public int getRatingsCount() {
				return ratingsCount;
			}

			public String getMaturityRating() {
				return maturityRating;
			}

			public boolean isAllowAnonLogging() {
				return allowAnonLogging;
			}

			public String getContentVersion() {
				return contentVersion;
			}

			public PanelizationSummary getPanelizationSummary() {
				return panelizationSummary;
			}

			public boolean isComicsContent() {
				return comicsContent;
			}

			public ImageLinks getImageLinks() {
				return imageLinks;
			}

			public String getLanguage() {
				return language;
			}

			public String getPreviewLink() {
				return previewLink;
			}

			public String getInfoLink() {
				return infoLink;
			}

			public String getCanonicalVolumeLink() {
				return canonicalVolumeLink;
			}
		    @JsonIgnoreProperties(ignoreUnknown = true)
			public static class IndustryIdentifier {
                private String type;
                private String identifier;
				public String getType() {
					return type;
				}
				public String getIdentifier() {
					return identifier;
				}

                // Getters and setters
            }
		    @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ReadingModes {
                private boolean text;
                private boolean image;
				public boolean isText() {
					return text;
				}
				public boolean isImage() {
					return image;
				}

                // Getters and setters
            }
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PanelizationSummary {
                private boolean containsEpubBubbles;
                private boolean containsImageBubbles;
				public boolean isContainsEpubBubbles() {
					return containsEpubBubbles;
				}
				public boolean isContainsImageBubbles() {
					return containsImageBubbles;
				}

                // Getters and setters
            }
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ImageLinks {
                @JsonProperty("smallThumbnail")
                private String smallThumbnail;
                @JsonProperty("thumbnail")
                private String thumbnail;
				public String getSmallThumbnail() {
					return smallThumbnail;
				}
				public String getThumbnail() {
					return thumbnail;
				}

                // Getters and setters
            }
        }
	    @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SaleInfo {
            private String country;
            private String saleability;
            private boolean isEbook;
			public String getCountry() {
				return country;
			}
			public String getSaleability() {
				return saleability;
			}
			public boolean getIsEbook() {
				return isEbook;
			}

            // Getters and setters
        }
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AccessInfo {
            private String country;
            private String viewability;
            private boolean embeddable;
            private boolean publicDomain;
            private String textToSpeechPermission;
            private Format epub;
            private Format pdf;
            private String webReaderLink;
            private String accessViewStatus;
            private boolean quoteSharingAllowed;

            // Getters and setters

            public String getCountry() {
				return country;
			}

			public String getViewability() {
				return viewability;
			}

			public boolean isEmbeddable() {
				return embeddable;
			}

			public boolean isPublicDomain() {
				return publicDomain;
			}

			public String getTextToSpeechPermission() {
				return textToSpeechPermission;
			}

			public Format getEpub() {
				return epub;
			}

			public Format getPdf() {
				return pdf;
			}

			public String getWebReaderLink() {
				return webReaderLink;
			}

			public String getAccessViewStatus() {
				return accessViewStatus;
			}

			public boolean isQuoteSharingAllowed() {
				return quoteSharingAllowed;
			}
		    @JsonIgnoreProperties(ignoreUnknown = true)
			public static class Format {
                private boolean isAvailable;

				public boolean isAvailable() {
					return isAvailable;
				}

                // Getters and setters
            }
        }
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SearchInfo {
            private String textSnippet;

			public String getTextSnippet() {
				return textSnippet;
			}

           
        }
    }
}
