package blog.ex.model.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	
	@NonNull
	@Column(name = "post_name")
	private String postTitle;
	
	@Column(name = "post_image")
	private String postImage;
	
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss-")
	@Column(name = "post_date")
	private LocalDateTime postDate;
	
	@NonNull
	@Column(name = "post_content")
	private String postContent;
	
	@NonNull
	@Column(name = "post_author")
	private Long postAuthor;
	
	@NonNull
	@Column(name = "visitor_count")
	private Long visitorCount;
	
	public PostEntity(@NonNull String postTitle, @NonNull String postImage, 
			@NonNull LocalDateTime postDate2, @NonNull String postContent, 
			@NonNull Long postAuthor,  @NonNull Long visitorCount) {
		this.postTitle = postTitle;
		this.postImage = postImage;
		this.postDate = postDate2;
		this.postContent = postContent;
		this.postAuthor = postAuthor;
		this.visitorCount = visitorCount;
	}
}
