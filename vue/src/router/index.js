import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manage',
    component: () => import('../views/Manage.vue'),
    redirect:"/SystemRecommend",
    children:[
      {path: 'SystemRecommend', name: 'SystemRecommend', component: () => import('../views/SystemRecommend.vue')},
      {path: 'ElectiveCourses', name: 'ElectiveCourses', component: () => import('../views/ElectiveCourses.vue')},
      {path: 'PEclass', name: 'PEclass', component: () => import('../views/PEclass.vue')},
      {path: 'Minor', name: 'Minor', component: () => import('../views/Minor.vue')},
      {path: 'Ordinary', name: 'Ordinary', component: () => import('../views/Ordinary.vue')},
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/Login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
