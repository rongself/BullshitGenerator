# 狗屁不通文章生成器JAVA版
# BullshitGenerator

这个分支用 JAVA 实现了“狗屁不通文章生成器”，核心代码保留了原版中文命名美学,保证原汁原味

参考原 repo 的 [Issue #39](https://github.com/menzi11/BullshitGenerator/issues/39)，添加了由 [@acdzh](https://github.com/acdzh) 收集的大量名言。
参考了 PHP 版 [Issue #37](https://github.com/menzi11/BullshitGenerator/pull/37)

可以对参数自定义：

| 参数名 | 说明 | 示例 |
| --- | --- | --- |
| `title` | 文章的主题 | 学生会退会 |
| `length` | 文章的字数 | 1000 |

* 图片宽度上限为 1024 像素
* 字数上限为 65536 字（以文本输出）或 2048 字（以图片输出）

~~不设定上限的话我的服务器说不定就要炸了⊂彡☆))∀`)~~

输出纯文本示例：[http://ronccc.com:8080/?word=膜蛤&length=6000](http://ronccc.com:8080/?word=膜蛤&length=6000)
