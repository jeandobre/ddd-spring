Vue.component("MainMenu", {
	  
  props: {
	apiTitle: String,
	apiSubtitle: String,
	
	footerYear: {
		type: String,
		default: new Date().getFullYear()
	},
	footerAppname: String,
	footerLink: String,
	footerVersion: String
  },
  
  data: () => ({ drawer: null }),
  
  computed: {
	menus: () => [{
		icon: "mdi-home",
		text: "Inicio",
		href: "/"
	}, {
		icon: "mdi-account-arrow-right-outline",
		text: "Solicitar análise",
		href: "/clients"
	}, {
		icon: "mdi-account-details",
		text: "Solicitações realizadas"
	}, {
		icon: "mdi-account-cash-outline",
		text: "Empréstimos efetivados"
	}],
	
	selectedItem() {
		const url = window.location.pathname;
		switch(url) {
			case "/": return 0;
			case "/clients": return 1;
			default: return 0; 
		}
	}
  },
  
  template: `
      <v-navigation-drawer
        v-model="drawer"
        app
        color="white"
        mini-variant
        mini-variant-width="140"
      >
        <v-img src="/images/logo.png" width="120" class="mt-2 ml-2"></v-img>

        <v-divider class="mx-2 my-2"></v-divider>

        <v-list>
	        <v-list-item-group
		        v-model="selectedItem"		        
		        color="teal"
		      >
	        	<v-list-item
		          v-for="(item, i) in menus"
		          :key="i"
		          style="height: 75px"
		          :href="item.href"
		        >
		          <v-list-item-icon>
		            <v-icon v-text="item.icon"></v-icon>
		          </v-list-item-icon>
		          <v-list-item-content>
		            <v-list-item-title v-text="item.text"></v-list-item-title>
		          </v-list-item-content>
		        </v-list-item>
	        </v-list-item-group>
        </v-list>
        
        <v-footer  
        	absolute       	 
        	padless
        >
	        <span class="font-weight-light">	          
	          <a
	            :href="footerLink"
	            target="_blank"
	          >{{ footerAppname }}</a>
	          &copy;
	          {{ footerYear }}
	         </span>	         
	         <div class="text-center" style="width: 100%">{{ footerVersion }}</div>
	    </v-footer>
        
      </v-navigation-drawer>`
});