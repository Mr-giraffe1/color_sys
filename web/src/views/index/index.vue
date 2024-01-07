<template>
    <div class="home">
      
      <div class="bg" :style="{ background: bgColor }">
        <div class="loginBut" @click="showLogin">登录</div>
       
      </div>
      <!-- <div style="border: 1px solid black;width: 50px;height: 50px;">123321</div> -->
      <div class="container">
        <el-dialog
          title="登录"
          :visible.sync="LoginVisible"
          width="25.5%"
          center>
          <el-form :model="logInForm" status-icon :rules="loginRule" ref="LoginRule" label-width="10px" class="demo-ruleForm">
            <el-form-item label="" prop="userName">
              <el-input v-model.number="logInForm.userName" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="" prop="pass">
              <el-input type="password" v-model="logInForm.pass" autocomplete="off" placeholder="请输入密码"></el-input>
            </el-form-item> 
            <el-form-item>
              <div class="login" @click="submitLogin('LoginRule')">登录</div>
             
            </el-form-item>
            <div class="signin" @click="siginVisible=true">立即注册</div> 
          </el-form>
          <!-- <span slot="footer" class="dialog-footer">
            <el-button @click="LoginVisible = false">取 消</el-button>
            <el-button type="primary" @click="submitLogin('LoginRule')">登 录</el-button>
          </span> -->
        </el-dialog>
  
        <el-dialog
          title="注册"
          :visible.sync="siginVisible"
          width="30%"
          center>
  
          <el-form :model="signinForm" status-icon :rules="signRules" ref="signinForm" label-width="70px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="newUserName">
              <el-input v-model.number="signinForm.newUserName"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input type="password" v-model="signinForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="signinForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item >
              <div style="display: flex;">
                <div class="signinBut" @click="createNewUser('signinForm')">注册</div>
                <div class="signReset" @click="resetSigninForm('signinForm')">重置</div>
              </div>
  
              
            </el-form-item>
          </el-form>
        </el-dialog>
        <div class="logo">
          <div class="logo-bg" ref="imageWrapper">
            <img @click="cut_back" :src="now_image_url" id="log_img" alt="" />
          </div>
        </div>
        <div class="colors">
          <div
            class="color-box"
            :key="index"
            v-for="(item, index) in colorList"
            @click="getColorItem(item)"
            v-clipboard:copy="item.hex"
            v-clipboard:success="onCopy"
          >
            <color-item :item="item" />
          </div>
        </div>
        <div class="content">
          <div class="content-color">
            <div class="circle-container" v-for="(item, index) in cmyk" :key="item.title">
              <div class="circle-title">{{item.title}}</div>
              <div class="circle" :style="{color: item.color}">
                {{currentCmky[index]}}
              </div>
              <div class="circle-right">
                <div class="line"  style="display: none;"
                  v-if="currentCmky[index] >= 50"
                  :style="{transform: `rotate(${180}deg)`}"></div>
                <div class="line"  style="display: none;"
                  v-else
                  :style="{transform: `rotate(${3.6 * currentCmky[index]}deg)`}"></div>
              </div>
              <div class="circle-left">
                <div class="line" style="display: none;"
                v-if="currentCmky[index] >= 50"
                :style="{transform: `rotate(${3.6 * currentCmky[index]}deg)`}"></div>
                <div class="line" style="display: none;"
                v-else
                :style="{transform: `rotate(${180}deg)`}"></div>
              </div>
            </div>
          </div>
          <div class="content-num">
            <num-rgb title="R" ref="num" :numbers="RGB[0]" />
            <num-rgb title="G" :numbers="RGB[1]" />
            <num-rgb title="B" :numbers="RGB[2]" />
          </div>
          <div class="content-name">
            <div class="content-name__chinese">
              {{chineseName}}
            </div>
            <div class="content-name__pinyin">
              {{chinsesPinyin.toUpperCase()}}
            </div>
          </div>
          <div class="tip-box" v-show="tipShow">
            <div class="tip">复制成功，{{bgColor}}！</div>
          </div>
        </div>
      </div>
    </div>
    
  </template>
  
  <style lang="scss" scoped>
  .signReset{
    display: inline-block;
      height: 42px;
      width: 100px;
      line-height: 1;
      white-space: nowrap;
      cursor: pointer;
      background: #FFF;
      border: 1px solid #DCDFE6;
      color: #606266;
      text-align: center;
      box-sizing: border-box;
      outline: 0;
      margin-left: 10px;
      transition: .1s;
      font-weight: 500;
      padding: 12px 20px;
      font-size:  16px;
      border-radius: 4px;
  }
  .signinBut{
    margin-bottom: 8px;
      width: 230px;
      height: 42px;
      background-color: #ff9a14;
  
      color: #fff;
      font-size: 16px;
      cursor: pointer;
      text-align: center;
      border: 0 none;
      border-radius: 4px;
      // *filter: chroma(color=#000);
      clear: both;
  }
  .signin{
    float: right;
      color: #0086F6;
  }
  .login{
    width: 320px;
    height: 42px;
    background-color: #ff9a14;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
    border: 0;
    border-radius: 4px;
    clear: both;
    display: flex;
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
  }
  .loginBut{
    position: absolute;
    width: 80px;
    height: 40px;
    top: 20px;
    right: 10px;
    // border: 1px solid black;
    font-family: cursive;
    color: #fff;
    font-size: 30px;
  }
  .home {
    height: 100%;
    width: 100%;
  //  height: 1080px;
  //  width: 1920px;
    .bg {
      // border: 10px solid black;
      position: fixed;
      // position: relative;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: url("../../assets/images/bg.png") #bbb;
      transition: all 1s linear;
    }
    .container {
      width: 960px;
      height: 100%;
      margin: 40px auto;
      position: relative;
      .logo {
        position: absolute;
        left: 870px;
        .logo-bg {
          width: 150px;
          height: 569px;
          // background: url("@/assets/images/back1.png") no-repeat;
          position: fixed;
          // border:1px black solid;
        }
      }
      .colors {
        width: 480px;
        height: 100%;
        position: absolute;
        left: -23px;
        top: 0;
        display: flex;
        justify-content: flex-start;
        flex-wrap: wrap;
        .color-box {
          width: 50px;
          height: 284px;
          margin-right: 20px;
          margin-top: 20px;
        }
      }
      .content {
        position: absolute;
        left: 434px;
        top: 20px;
        height: 507px;
        width: 410px;
        .content-color {
          position: fixed;
          width: 100px;
          .circle-container {
            height: 86px;
            position: relative;
            width: 50px;
            z-index: 500;
            border-top: 1px solid #fff;
            &:nth-child(2) {
              .circle-right,
              .circle-left {
                .line {
                  background-position: 0 -50px;
                }
              }
            }
            &:nth-child(3) {
              .circle-right,
              .circle-left {
                .line {
                  background-position: 0 -100px;
                }
              }
            }
            &:nth-child(4) {
              .circle-right,
              .circle-left {
                .line {
                  background-position: 0 -150px;
                }
              }
            }
            .circle-title {
              height: 26px;
              line-height: 26px;
              color: #fff;
              font-size: 10px;
            }
            .circle {
              background: url("../../assets/images/circle.png") no-repeat;
              display: block;
              height: 50px;
              left: 0;
              position: absolute;
              top: 26px;
              width: 50px;
              display: flex;
              align-items: center;
              justify-content: center;
              color: #fff;
              font-family: sans-serif;
              font-size: 24px;
              font-weight: 300;
            }
            .circle-right {
              position: absolute;
              left: 0;
              top: 26px;
              width: 50px;
              height: 50px;
              mask-image: url("../../assets/images/circle_r.png");
              .line {
                display: block;
                height: 50px;
                left: 1px;
                position: absolute;
                top: 0;
                width: 50px;
                background: url("../../assets/images/colorBox.png") no-repeat;
                background-position: 0 0;
                transform: rotate(180deg);
                transition: all 0.5s linear;
              }
            }
            .circle-left {
              position: absolute;
              left: 0;
              top: 26px;
              width: 50px;
              height: 50px;
              mask-image: url("../../assets/images/circle_l.png");
              .line {
                display: block;
                height: 50px;
                left: 1px;
                position: absolute;
                top: 0;
                width: 50px;
                background: url("../../assets/images/colorBox.png") no-repeat;
                background-position: 0 0;
                transform: rotate(180deg);
                transition-delay: 0.5s;
                transition: all 0.5s linear;
              }
            }
          }
        }
        .content-num {
          position: fixed;
          top: 410px;
          width: 50px;
        }
        .content-name {
          position: fixed;
          top: 100px;
          color: #fff;
          .content-name__chinese {
            font-family: cursive;
            font-weight: normal;
            font-size: 100px;
            color: #fff;
            margin: 0 auto;
            width: 100px;
            text-align: center;
            background-position: center top;
            background-repeat: no-repeat;
          }
          .content-name__pinyin {
            font-size: 16px;
            width: 500px;
            margin-top: 30px;
            text-align: center;
            font-family: Georgia;
            font-weight: bold;
            -webkit-font-smoothing: antialiased;
          }
        }
        .footer {
          position: fixed;
          width: 500px;
          bottom: 0;
          text-align: center;
          color: #fff;
          font-size: 10px;
          font-family: cursive;
        }
        .tip-box {
          width: 500px;
          position: fixed;
          top: 40px;
          .tip {
            // position: fixed;
            // top: 40px;
            // left: 1200 * $vw;
            width: 180px;
            text-align: center;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            color: #fff;
            border: 1px solid #fff;
          }
        }
      }
    }
  }
  </style>
  
  <script>
  import ColorItem from "@/components/color/ColorItem";
  import NumRgb from "@/components/color/Num";
  import html2canvas from "html2canvas";
  import { listToShow} from "@/api/colorInfo/colorInfo";
  
  export default {
    name: "Home",
    components: {
      ColorItem,
      NumRgb,
    },
    onExport() {
      const clientWidth = this.$refs.imageWrapper.offsetWidth;
      const clientHeight = this.$refs.imageWrapper.offsetHeight;
      const kh = [clientWidth, clientHeight];
  
      html2canvas(this.$refs.imageWrapper, { useCORS: true, logging: true }).then(
        (canvas) => {
          const dataURL = canvas.toDataURL("image/png");
          this.download(dataURL, kh);
        }
      );
      html2canvas(this.$refs.imageDom, {
        backgroundColor: this.now_color,
      });
    },
    getUrlBase64(url, kh) {
      return new Promise((resolve) => {
        let canvas = document.createElement("canvas");
        const ctx = canvas.getContext("2d");
        const img = new Image();
        img.crossOrigin = "Anonymous"; // 允许跨域
        img.src = url;
        img.onload = () => {
          // eslint-disable-next-line prefer-destructuring
          canvas.height = kh[1];
          // eslint-disable-next-line prefer-destructuring
          canvas.width = kh[0];
          ctx.drawImage(img, 0, 0, kh[0], kh[1]);
          const dataURL = canvas.toDataURL("image/png");
          canvas = null;
          resolve(dataURL);
        };
      });
    },
    download(imgUrl, kh) {
      this.getUrlBase64(imgUrl, kh).then((base64) => {
        const link = document.createElement("a");
        link.href = base64;
        link.download = `${this.currentRobot.nickname}书签.png`;
        link.click();
      });
    },
    created() {
      this.getAllcolor();
      // this.fetchData();
    },
    methods: {
      resetSigninForm(formName) {
          this.$refs[formName].resetFields();
        },
      createNewUser(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              alert('submit!');
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
      submitLogin(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              alert('submit!');
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
      showLogin(){
        this.LoginVisible=true;
      },
      fetchData() {
        // 发送跨域请求
        // this.$axios.get('http://localhost:8086/Color/getAllColor')
        this.$axios.post('http://localhost:8086/colorInfo/colorInfo/listToShow')
          .then(response => {
            
            console.log(response.data)
          })
          .catch(error => {
            console.error('Error fetching data:', error);
          });
      },
      
      async getAllcolor() {
        this.$axios({
          headers: {
        'Access-Contro1-Allow-Origin': '*'
        
      },
          method: "post",
          // url: "/api/Color/getAllColor",
          url: "http://localhost:8086/colorInfo/colorInfo/listToShow",
          // url: "/api/colorInfo/colorInfo/listToShow",
        }).then((res) => {
          console.log(res.data)
          if(res!=null){
            this.colorList=res.data
            console.log("123")
          }
          
        });
      },
      getColorItem(item) {
        this.selectGoods
        this.bgColor = item.hex;
        this.currentCmky = item.CMYK;
        this.RGB = item.RGB;
        this.chineseName = item.name;
        this.chinsesPinyin = item.pinyin;
        this.tipShow = true;
        setTimeout(() => {
          this.tipShow = false;
        }, 1000);
        document.title = `${this.chineseName} 中国传统颜色`;
      },
      onCopy(e) {
        console.log(e.text);
      },
      cut_back() {
        console.log(this.now_image_url);
        console.log(this.now_image_id);
        console.log(this.log_image[0].url);
        this.now_image_url = this.log_image[this.now_image_id % 6].url;
        this.now_image_id++;
        console.log(this.now_image_id);
      },
    },
    data() {
      var chaeckNewUserName = (rule, value, callback) => {
          if (!value) {
            return callback(new Error('用户名不能为空'));
          }
        };
        var checkSigninPass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (this.signinForm.checkPass !== '') {
              this.$refs.signinForm.validateField('checkPass');
            }
            callback();
          }
        };
        var checkSigninPassAgain = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.signinForm.pass) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
      var checkUserName = (loginRule, value, callback) => {
          if (!value) {
            return callback(new Error('账号不能为空'));
          }
        };
      var checkPass = (loginRule, value, callback) => {
        if (!value) {
          callback(new Error('请输入密码'));
        }
      };
      return {
        logInForm:{},
        LoginVisible: false,
        siginVisible:false,
        signinForm:{},
        loginRule:{
          pass: [
              { validator: checkPass, trigger: 'blur' }
            ],
          userName: [
              { validator: checkUserName, trigger: 'blur' }
            ]
        },
        signRules: {
            pass: [
              { validator: checkSigninPass, trigger: 'blur' }
            ],
            checkPass: [
              { validator: checkSigninPassAgain, trigger: 'blur' }
            ],
            newUserName: [
              { validator: chaeckNewUserName, trigger: 'blur' }
            ]
        },
        now_color: "red",
        now_image_id: 0,
        now_image_url: require("@/assets/images/back1.png"),
        log_image: [
          {
            id: 0,
            url: require("@/assets/images/back1.png"),
          },
          {
            id: 1,
            url: require("@/assets/images/back2.png"),
          },
          {
            id: 2,
            url: require("@/assets/images/back3.png"),
          },
          {
            id: 3,
            url: require("@/assets/images/back4.png"),
          },
          {
            id: 4,
            url: require("@/assets/images/back5.png"),
          },
          {
            id: 5,
            url: require("@/assets/images/back6.png"),
          },
        ],
        colorList:[],
        bgColor: "#bbb",
        cmyk: [
          {
            title: "C",
            color: "#0093D3",
          },
          {
            title: "M",
            color: "#CC006B",
          },
          {
            title: "Y",
            color: "#FFF10C",
          },
          {
            title: "K",
            color: "#000000",
          },
        ],
        currentCmky: [0, 0, 0, 0],
        RGB: [0, 0, 0],
        chineseName: "中国传统颜色",
        chinsesPinyin: "COLOR",
        tipShow: false,
      };
    },
  };
  </script>
  