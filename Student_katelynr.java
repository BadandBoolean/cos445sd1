// Student_katelynr.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Katelyn and Aliya
import java.util.Arrays;
import java.util.List;

public class Student_katelynr implements Student {
  public int[] getApplications(
      int N,
      double S,
      double T,
      double W, //
      double aptitude, // A_s
      List<Double> schools, // qualities best --> worst
      List<Double> synergies) {

    // create copy of synergies
    double[] syns = new double[synergies.size()];
    for (int i = 0; i < synergies.size(); i++) {
      syns[i] = synergies.get(i);
    }

    int n = schools.size();
    int percentage = (int) (aptitude / S);

    int orig_index = (int) Math.floor((percentage) * n);

    int[] top_schools = new int[10];
    double[] top_synergies = new double[10];

    if ((syns.length - orig_index) < 10) {
      // you are gonna run over the end of the array so you might as well run it from
      // the end
      int index = 0;
      for (int i = (syns.length - 1); i >= (syns.length - 10); i--) {
        top_synergies[index] = syns[i];
        index++;
      }
      Arrays.sort(top_synergies); // sorted from least synergy to most
      // filling the top schools array from the back
      index = 9;
      for (int i = 0; i < top_synergies.length; i++) {
        // all values are in the back of syns anyway so this makes it easier
        for (int j = (syns.length - 1); j >= (syns.length - 10); j--) {
          if (top_synergies[i] == syns[j]) {
            top_schools[index] = j;
            index--;
            syns[j] = -1;
            break;
          }
        }
      }
    }

    else {
      // can just start with that as the top index and keep going
      int index = 0;
      for (int i = orig_index; i < (orig_index + 10); i++) {
        top_synergies[index] = syns[i];
        index++;
      }
      Arrays.sort(top_synergies); // sorted from least synergy to most
      index = 9;
      for (int i = 0; i < top_synergies.length; i++) {
        for (int j = orig_index; j < (orig_index + 10); j++) {
          if (top_synergies[i] == syns[j]) {
            top_schools[index] = j;
            index--;
            syns[j] = -1;
            break;
          }
        }
      }
    }

    return top_schools;
  }
}