const panels = document.querySelectorAll(".panel");
//querySelectorAll() 方法返回一个包含匹配元素的所有元素的列表，文档中的顺序。
panels.forEach(panel => {
    //forEach() 方法对数组的每个元素执行一次提供的函数。
    //panel.addEventListener() 方法用于向指定元素添加事件句柄。
    //click 事件在用户点击某个对象时触发。
    //() => {} 箭头函数
    //箭头函数表达式的语法比函数表达式更短，并且不绑定自己的this，arguments，super或new.target。
    panel.addEventListener('click', () => {
        removeActiveClasses();
        panel.classList.add("active")
    })
});
function removeActiveClasses(){
    panels.forEach(panel => {
        //classList 属性返回元素的类名，作为 DOMTokenList 对象。
        //DOMTokenList 对象是一个类数组的对象，用于在元素的 class 属性中进行操作。
        panel.classList.remove("active")
    });
}