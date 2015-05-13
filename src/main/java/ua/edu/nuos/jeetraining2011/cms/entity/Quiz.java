package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 11:14 AM
 */
@Entity
public class Quiz extends Task {
    @ElementCollection
    private List<String> questions;
    @ElementCollection
    private Map<Integer, List<Integer>> answers;
    @ElementCollection
    private List<List<String>> questionsPool;
    @ElementCollection
    private List<Map<Integer, List<Integer>>> answersPool;

    public Quiz() {

    }

    public Quiz(String description, Date dateBegin, Date dateEnd, Course course, List<String> questions, Map<Integer, List<Integer>> answers, List<List<String>> questionsPool, List<Map<Integer, List<Integer>>> answersPool) {
        super(description, dateBegin, dateEnd, course);
        this.questions = questions;
        this.answers = answers;
        this.questionsPool = questionsPool;
        this.answersPool = answersPool;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public Map<Integer, List<Integer>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, List<Integer>> answers) {
        this.answers = answers;
    }

    public List<List<String>> getQuestionsPool() {
        return questionsPool;
    }

    public void setQuestionsPool(List<List<String>> questionsPool) {
        this.questionsPool = questionsPool;
    }

    public List<Map<Integer, List<Integer>>> getAnswersPool() {
        return answersPool;
    }

    public void setAnswersPool(List<Map<Integer, List<Integer>>> answersPool) {
        this.answersPool = answersPool;
    }
}
