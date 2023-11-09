import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false, length = 30)
    private String user_id;
    @Column(nullable = false, length = 30)
    private String user_password;
    @Column(nullable = false, length = 30)
    private String user_name;
    @Column(nullable = false, length = 30)
    private int start_date;
    @Column(nullable = false, length = 30)
    private String profile_photo;
    @Column(nullable = false, length = 30)
    private int user_age;

}
