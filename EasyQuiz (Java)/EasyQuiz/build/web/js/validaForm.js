$(document).ready(function () {
                $("#formCadastro").validate({
                    rules: {

                        nome: {
                            required: true,
                            minlength: 10
                        },

                        emailCadastro: {
                            required: true,
                            email: true
                        },

                        data: {
                            required: true,
                            date: true
                        },

                        escolaridade: {
                            required: true
                        },

                        senhaCadastro: {
                            required: true,
                            rangelength: [8, 20]
                        },

                        confirma_senha: {
                            required: true,
                            rangelength: [8, 20],
                            equalTo: "#senhaCadastro"
                        }
                    },
                    //For custom messages
                    messages: {
                        nome: {
                            required: "Entre com um nome",
                            minlength: "Mínimo 10 caracteres"
                        },

                        emailCadastro: {
                            required: "Digite um email",
                            email: "Digite um email válido"
                        },

                        data: {
                            required: "Entre com uma data",
                            date: "Entre com uma data válida"
                        },

                        escolaridade: {
                            required: "Escolha uma escolaridade"
                        },

                        senha: {
                            required: "Digite uma senha",
                            rangelength: "A senha deve ter entre 8 e 20 caracteres"
                        },

                        confirma_senha: {
                            required: "Confirme a senha",
                            rangelength: "A senha deve ter entre 8 e 20 caracteres",
                            equalTo: "As senhas não correspondem"
                        }
                    },
                    errorElement: 'div',
                    errorPlacement: function (error, element) {
                        var placement = $(element).data('error');
                        if (placement) {
                            $(placement).append(error);
                        } else {
                            error.insertAfter(element);
                        }
                    }
                });
            });