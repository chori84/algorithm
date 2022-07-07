package test1;

import java.util.*;

class Solution {

    class CarVote implements Comparable<CarVote> {
        String name;
        int vote = 0;

        public CarVote(String name, int vote) {
            this.name = name;
            this.vote = vote;
        }

        @Override
        public int compareTo(CarVote c) {
            if (this.vote == c.vote) {
                return c.name.compareTo(this.name);
            } else {
                return this.vote - c.vote;
            }
        }
    }

    public String solution(String[] votes, int k) {
        String answer = "";

        Map<String, Integer> carVoteMap = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            if (Objects.isNull(carVoteMap.get(votes[i]))) {
                carVoteMap.put(votes[i], 1);
            } else {
                carVoteMap.put(votes[i], carVoteMap.get(votes[i]) + 1);
            }
        }

        Iterator<String> nameIter = carVoteMap.keySet().iterator();
        List<CarVote> carVotes = new ArrayList<>();
        while (nameIter.hasNext()) {
            String name = nameIter.next();
            CarVote carVote = new CarVote(name, carVoteMap.get(name));

            carVotes.add(carVote);
        }

        Collections.sort(carVotes);

        int kVote = 0;
        for (int i = carVotes.size() - 1; i >= carVotes.size() - k; i--) {
            kVote += carVotes.get(i).vote;
        }

        int sumVote = 0;
        for (int i = 0; i < carVotes.size(); i++) {
            CarVote carVote = carVotes.get(i);
            sumVote += carVote.vote;

            if (sumVote >= kVote) {
                return answer;
            }
            answer = carVote.name;
        }

        return answer;
    }
}