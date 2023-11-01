import java.util.*;

public class Courses {
  public List<String> topologicalSort(String[] courses, int numCourses) {
      List<String> result = new ArrayList<String>();
      List<List<Integer>> graph = new ArrayList<>(numCourses);
      // degrees/prerequisites
      int[] courseReq = new int[numCourses];

      // add courses/nodes to graph
      for (int i = 0; i < numCourses; i++) {
        graph.add(new ArrayList<>());
      }

      // course 1DV002;1DV001 ex.
      for (String course : courses) {
        String[] courseArr = course.split(";");
        int courseCode = Integer.parseInt(courseArr[0].substring(3)) - 1;
        int prereq = Integer.parseInt(courseArr[1].substring(3)) - 1;

        graph.get(prereq).add(courseCode);
        courseReq[courseCode]++;
      }

      Queue<Integer> queue = new LinkedList<>();
      // if the prequisite course == 0, add to queue.
      for (int i = 0; i < numCourses; i++) {
        if (courseReq[i] == 0) {
          queue.add(i);
        }
      }

      while (!queue.isEmpty()) {
        // first element from queue.
        int course2 = queue.poll();
        // finished course
        result.add("1DV00" + (course2 + 1));

        for (int nextCourse : graph.get(course2)) {
          courseReq[nextCourse]--;

          // if all prerequisites are satisfied, add to queue.
          if (courseReq[nextCourse] == 0) {
              queue.add(nextCourse);
            }
          }
        }

      return result;
    }
}