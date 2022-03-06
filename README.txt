project folder:
sclkan-cs1c-project07/


Brief description of submitted files:

src/FHSort.java
    - Codes for the quicksort algorithm

src/QuickSortBenchmark.java
    - A benchmark test that investigates the recursion limit of arrays of various sizes
    - Investigates recursions limits from 2 to 300 in steps of 2
    - Captures run time on various array sizes: starting with 20,000 integers up to 3,000,000 (20 intervals)
    - Each test case is executed 3 times with the average recorded in quicksort_benchmark_raw.csv

resources/DataVisualizationScript.ipynb
    - A Jupyter notebook that was used to create the line graphs for this project
    - Language: Python
    - Libraries: pandas, numpy, matplotlib, seaborn

resources/full_results_with_comment.png
    - An overlaid line graph that illustrates the impact of recursion limit on different array sizes in terms of run time
    - This graph contains all data points from the raw csv file
    - Contains comments and annotations
    - For a better viewing experience, please download the image file instead of viewing it on github

resources/subset_with_comment.png
    - A second graph where I filtered and zoomed to a particular range of interest for recursion limit vs array size
    - Only contains the following array sizes: 30k, 40k, 70k, 100k, 200k, 500k, 800k, 3mil
    - Recursion limits are set to between 2 and 40
    - Identifies the optimal recursion limit of the arrays mentioned above
    - Contains comments and annotations
    - For a better viewing experience, please download the image file instead of viewing it on github

resources/quicksort_benchmark_raw.csv
    - csv output of QuickSortBenchmark.java

README.txt
    - description of submitted files