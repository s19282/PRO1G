def list = [5,7,2,4,66,11,38,64,11,98]
list.sort(new Comparator<Integer>() {
    @Override
    int compare(Integer o1, Integer o2) {
        return o2-o1
    }
})
println list

def list_2 = [5,7,2,4,66,11,38,64,11,98]
list_2.sort(Comparator.reverseOrder())
println list_2