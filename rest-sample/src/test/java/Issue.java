import java.util.Objects;

public class Issue {

    private int id;
    private String summary;
    private String description;

    private Category category;
    private Project project;

    public int getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Project getProject() {
        return project;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Issue withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id && Objects.equals(summary, issue.summary) && Objects.equals(description, issue.description) && Objects.equals(category, issue.category) && Objects.equals(project, issue.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, description, category, project);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", project=" + project +
                '}';
    }
}
