const obj = {
  a: "1",
  b: {
    test: "test",
  },
};

function foo() {
  function bar() {
    console.trace();
  }
  bar();
}

const action = "action";
const actionName = "@SOMETHING";
const prevState = "prev state";

console.group(`%c${action} %c${actionName}`, "color: #aaa", "font-weight: 700");
console.groupCollapsed(prevState);
console.groupEnd();
console.groupCollapsed(`%c${action}`, "color: #448ee4; font-weight: 700");
foo();
console.groupEnd();
console.groupEnd();
