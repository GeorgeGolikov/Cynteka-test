#CYNTEKA тестовое задание
Решение задачи разбито на несколько этапов: чтение из файла в общий список, разбиение общего списка надвое, создание из двух списков списка пар похожих строк, запись результата в файл.\
За каждый этап отвечает соответствующий класс: Reader, Decoupler, PairsCreator, Writer.\
Для создания пар похожих строк необходимо понимать, как определяется это сходство, этот алгоритм описан в классе DefinitionOfSimilar.\
Те строки, которые похожи не лексически, а семантически (по смыслу), заносятся в хранилище NonLexicalSimilaritiesStorage.\
\
PairsCreator просматривает последовательно строки первого списка, сравнивая их с каждой строкой второго списка. Далее DefinitionOfSimiliar определяет схожи строки или нет.\
Если строка содержит несколько слов, то рекурсивно происходит определение сходства отдельных слов этой строки с отдельными словами второй строки.\
При этом учитываются предлоги - они сравниваются вместе со словом, к которому относятся, как одно целое.\
При первом нахождении похожей строки цикл прерывается, остальные элементы не обрабатываются.\
Те элементы второго списка, которые уже добавлены в пару, второй раз обрабатываться не будут (при проходе следующей строки первого списка по второму списку в поисках совпадения).