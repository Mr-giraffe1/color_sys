<template>
  <section class="main">
    <app-main></app-main>
    <div class="footer flex flex-js-c flex-dir">
      <div class="content flex flex-js-b padding-all-m">
        <div class="item flex flex-ai-c">
          <img src="https://11317792.s61i.faiusr.com/4/AD0IoOSyBRAEGAAgu5KzvwUo2KPY-QcwJDgy.png.webp"/>
          <i class="line margin-left-s margin-right-s"></i>
          <div class="flex flex-dir flex-js-c">
            <span class="title">地址</span>
            <p class="info font-size-sm margin-top-s">两江新区泰山大道东段98号华宇北城商务街2栋17-9</p>
          </div>
        </div>
        <div class="item flex flex-ai-c">
          <img src="https://11317792.s61i.faiusr.com/4/AD0IoOSyBRAEGAAgx5KzvwUoocP4yAUwMjgh.png.webp"/>
          <i class="line margin-left-s margin-right-s"></i>
          <div class="flex flex-dir flex-js-c">
            <span class="title">邮箱</span>
            <p class="info font-size-sm margin-top-s">578746779@qq.com</p>
          </div>
        </div>
        <div class="item flex flex-ai-c">
          <img src="https://11317792.s61i.faiusr.com/4/AD0IoOSyBRAEGAAgxJKzvwUoocjV6QMwMjgn.png.webp"/>
          <i class="line margin-left-s margin-right-s"></i>
          <div class="flex flex-dir flex-js-c">
            <span class="title">电话</span>
            <p class="info font-size-sm margin-top-s">63072099</p>
          </div>
        </div>
      </div>
      <div class="address padding-top-m flex flex-dir flex-ai-c font-size-sm">
        <p class="font-color-gray margin-bottom-s">©2023 飓风传媒-服装 版权所有</p>
        <p class="font-color-gray">恒东飓风传媒</p>
      </div>
    </div>
  </section>
</template>

<script lang="ts">
  import appMain from './main/index.vue';

  import { defineComponent, ref, provide } from 'vue';
  import { RouteRecordType } from '@/router';

  export default defineComponent({
    name: "layout",
    components: {
      appMain
    },
    setup(props, context) {
     /* const { store } = getApi();

      /!**
       * 过滤隐藏路由
       * @param permission_routers
       *!/
      const filterHiddenRouter = (permission_routers: RouteRecordType[]): RouteRecordType[]  => {
        return permission_routers.filter((route: RouteRecordType) => {
          if (!route.hidden) {
            if (route.children && route.children.length) {
              route.children = filterHiddenRouter(route.children)
            }
            return true;
          }
          return false;
        })
      };

      const permission_routers: RouteRecordType[] = filterHiddenRouter(store.getters.permission_routers);

      // 控制折叠菜单
      let collapse = ref<boolean>(false);

      provide('collapse', collapse);
      provide('permission_routers', permission_routers)*/
    }
  })
</script>

<style lang="scss" scoped>
  .footer {
    height: 250px;
    background-color: #161616;
    padding: 0 300px;
    box-sizing: border-box;
    .content {
      .item {
        .line {
          width: 3px;
          height: 30px;
          background-color: $color-main;
        }
        div {
          .title {
            color: white;
          }
          .info {
            color: $color-gray;
          }
        }
        &:nth-child(1) {
          > img {
            height: 50px;
            width: 36px;
          }
        }
        &:nth-child(2) {
          > img {
            height: 33px;
            width: 50px;
          }
        }
        &:nth-child(3) {
          > img {
            height: 39px;
            width: 50px;
          }
        }
      }
    }
    .address {
      border-top: $color-gray 1px solid;
    }
  }
</style>
