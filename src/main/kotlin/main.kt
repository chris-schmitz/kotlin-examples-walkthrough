fun main(args: Array<String>) {

    val exampleClassList: List<ExampleCodeInterface> = listOf(
        CollectionExamples(),
        ScopeFunctionExamples(),
        DelegationExamples(),
        ProductivityBoostersExample()
    )

    exampleClassList.forEach { it.runExamples() }

//    exampleClassList.forEach { exampleSet ->
//        exampleSet.runExamples()
//    }
}
