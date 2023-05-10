package org.sabourin.service;

import org.sabourin.bd.BD;
import org.sabourin.exceptions.MauvaiseQuestion;
import org.sabourin.modele.VDQuestion;
import org.sabourin.modele.VDVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Service {

    private BD maBD;

    public Service(BD maBD){
        this.maBD = maBD;
    }

    public void creerQuestion(VDQuestion vdQuestion) throws MauvaiseQuestion {
        // Validation
        if (vdQuestion.texteQuestion == null || vdQuestion.texteQuestion.trim().length() == 0) throw new MauvaiseQuestion("Question vide");
        if (vdQuestion.texteQuestion.trim().length() < 5) throw new MauvaiseQuestion("Question trop courte");
        if (vdQuestion.texteQuestion.trim().length() > 255) throw new MauvaiseQuestion("Question trop longue");
        if (vdQuestion.idQuestion != null) throw new MauvaiseQuestion("Id non nul. La BD doit le gérer");

        // Doublon du texte de la question
        for (VDQuestion q : toutesLesQuestions()){
            if (q.texteQuestion.toUpperCase().equals(vdQuestion.texteQuestion.toUpperCase())){
                    throw new MauvaiseQuestion("Question existante");
            }
        }

        // Ajout
        vdQuestion.idQuestion = maBD.monDao().insertQuestion(vdQuestion);
    }

    
    public void creerVote(VDVote vdVote) {

    }

    
    public List<VDQuestion> toutesLesQuestions() {
        //TODO Présentement :   retourne une liste vide
        //TODO À faire :        trier la liste reçue en BD par le nombre de votes et la retourner


        return new ArrayList<>();
    }

    
    public float moyenneVotes(VDQuestion question) {
        return 0;
    }

    
    public Map<Integer, Integer> distributionVotes(VDQuestion question) {
        return null;
    }
	
	public void supprimerQuestions(){
	}
	
	public void supprimerVotes(){
	}
}
