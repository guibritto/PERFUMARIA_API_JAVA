package br.com.fiap.api_rest.model;

// Enum que representa as categorias de produtos disponíveis na perfumaria
public enum Categoria {

    // ---------------- PERFUMARIA ----------------
    PERFUME("Perfumes e fragrâncias em geral"),
    COLONIA("Colônias e body splash"),
    DESODORANTE("Desodorantes corporais e antitranspirantes"),

    // ---------------- MAQUIAGEM ----------------
    MAQUIAGEM("Produtos de maquiagem como batons, sombras e bases"),
    BATOM("Batom e gloss labial"),
    BASE("Bases, corretivos e pós faciais"),
    MASCARA_CILIOS("Máscaras e delineadores para os olhos"),

    // ---------------- CUIDADOS COM O CORPO ----------------
    HIDRATANTE("Hidratantes corporais e faciais"),
    OLEO_CORPORAL("Óleos e cremes corporais"),
    SABONETE("Sabonetes líquidos e em barra"),
    ESFOLIANTE("Esfoliantes corporais e faciais"),

    // ---------------- CUIDADOS COM O CABELO ----------------
    SHAMPOO("Shampoos para diversos tipos de cabelo"),
    CONDICIONADOR("Condicionadores e máscaras capilares"),
    FINALIZADOR("Produtos finalizadores como leave-in e sprays"),
    COLORACAO("Tinturas e produtos para coloração capilar"),

    // ---------------- SKINCARE ----------------
    SKINCARE("Produtos de cuidados com a pele (skincare)"),
    PROTETOR_SOLAR("Protetores solares e bloqueadores UV"),
    SERUM("Séruns, ácidos e hidratantes faciais"),

    // ---------------- UNHAS ----------------
    ESMALTE("Esmaltes e produtos para unhas"),
    REMOVEDOR_ESMALTE("Removedores e fortalecedores de unha"),

    // ---------------- BARBEARIA ----------------
    POS_BARBA("Pós-barba e loções masculinas"),
    GEL_BARBEAR("Géis, espumas e cremes para barbear"),

    // ---------------- AMBIENTE ----------------
    VELA("Velas aromáticas e difusores de ambiente"),
    AROMATIZADOR("Aromatizadores e essências para ambiente"),

    // ---------------- KITS E ACESSÓRIOS ----------------
    KIT("Kits presenteáveis com combinações de produtos"),
    ACESSORIO("Acessórios como pincéis, esponjas e nécessaires");

    // Atributo que descreve a categoria
    private String descricao;

    // Construtor do enum, que define a descrição de cada categoria
    private Categoria(String descricao) {
        this.descricao = descricao;
    }

    // Getter que retorna a descrição da categoria
    public String getDescricao() {
        return descricao;
    }

}