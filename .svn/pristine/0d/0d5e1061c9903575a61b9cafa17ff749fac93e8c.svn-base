## vue3学习笔记
#### computed计算属性

```vue
<script setup>
//引入computed
import { ref, computed } from 'vue'

let id = 0

const newTodo = ref('')
const hideCompleted = ref(false)
const todos = ref([
  { id: id++, text: 'Learn HTML', done: true },
  { id: id++, text: 'Learn JavaScript', done: true },
  { id: id++, text: 'Learn Vue', done: false }
])
//定义computed常量
const filteregTodos = computed(()=>{
  return hideCompleted.value ?  todos.value.filter((t)=> !t.done):todos.value 
})
function addTodo() {
  todos.value.push({ id: id++, text: newTodo.value, done: false })
  newTodo.value = ''
}

function removeTodo(todo) {
  todos.value = todos.value.filter((t) => t !== todo)
}
</script>

<template>
  <form @submit.prevent="addTodo">
    <input v-model="newTodo">
    <button>Add Todo</button>
  </form>
  <ul>
     <!-- 使用computed常量-->
    <li v-for="todo in filteregTodos" :key="todo.id">
      <input type="checkbox" v-model="todo.done">
      <span :class="{ done: todo.done }">{{ todo.text }}</span>
      <button @click="removeTodo(todo)">X</button>
    </li>
  </ul>
  <button @click="hideCompleted = !hideCompleted">
    {{ hideCompleted ? 'Show all' : 'Hide completed' }}
  </button>
</template>

<style>
.done {
  text-decoration: line-through;
}
</style>
```

computed属性定义的常量是一个可以根据其他数据动态更新

#### 生命周期
##### onMounted

```vue
<script setup>
	//引用onMounted
import { ref ,onMounted} from 'vue'

    //定义一个同名模板引用，使用null进行初始化，当 <script setup> 执行时，DOM 元素还不存在。模板引用 ref 只能在组件挂载后访问。
const pElementRef = ref(null)
//使用onMounted
onMounted(()=>{
    //直接通过.value调用ref模板引用
  pElementRef.value.textContent="321"
})
</script>

<template>
  <p ref="pElementRef">hello</p>
</template>
```

#### 监听器
#### watch

```vue
<script setup>
    //引入监听器
import { ref, watch } from 'vue'

const todoId = ref(1)
const todoData = ref(null)
//使用监听器监听todoId变量第一个参数为初始量，第二个参数为改变后的变量
watch(todoId,(newCount)=>{
  fetchData()
})
//watch(todoId, fetchData)
async function fetchData() {
  todoData.value = null
  const res = await fetch(
    `https://jsonplaceholder.typicode.com/todos/${todoId.value}`
  )
  todoData.value = await res.json()
}

fetchData()
</script>

<template>
  <p>Todo id: {{ todoId }}</p>
  <button @click="todoId++">Fetch next todo</button>
  <p v-if="!todoData">Loading...</p>
  <pre v-else>{{ todoData }}</pre>
</template>
```

#### 父组件向子组件传参
##### props

```vue
<script setup>
import { ref } from 'vue'
import ChildComp from './ChildComp.vue'
const greeting = ref('Hello from parent')
</script>

<template>
<!--子组件中定义了props时，父组件直接在使用子组件时将参数传入子组件即可-->
  <ChildComp msg="qwerasdzxc" />
   <ChildComp :msg="greeting" />
</template>
```

```vue
<script setup>
    //defineProps() 是一个编译时宏，并不需要导入
const props = defineProps({
    //定义参数名
  msg: String
})
</script>

<template>
  <h2>{{ msg || 'No props passed yet' }}</h2>
</template>
```

#### 子组件触发父组件事件
#### emits

```vue
<script setup>
import { ref } from 'vue'
import ChildComp from './ChildComp.vue'
const childMsg = ref('No child msg yet')
function getMsg(msg){
  childMsg.value=msg
}
</script>

<template>
<!-- 在调用子组件时监听定义的事件-->
	<ChildComp @response="(msg) => childMsg = msg"/>
	<ChildComp @response="(msg) => getMsg(msg)"/>
  <p>{{ childMsg }}</p>
</template>
```

```vue
<script setup>

const emit = defineEmits(['response'])
// emit() 的第一个参数是事件的名称。其他所有参数都将传递给事件监听器
emit('response', 'hello from child')
</script>

<template>
  <h2>Child component</h2>
</template>
```

插槽

##### slots

```vue
<script setup>
import { ref } from 'vue'
import ChildComp from './ChildComp.vue'

const msg = ref('from parent')
</script>

<template>
<!--父组件对子组件传值时，将看到父组件传的值-->
  <ChildComp>Message: {{ msg }}</ChildComp>
</template>
```

```vue
<template>
<!--<slot> 插口中的内容将被当作“默认”内容：它会在父组件没有传递任何插槽内容时显示，父组件传递的值将在插槽内部显示-->
  <slot>Fallback content</slot>
</template>
```

