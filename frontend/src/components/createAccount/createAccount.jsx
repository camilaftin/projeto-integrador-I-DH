import { useForm } from "react-hook-form";
import "./createAccount.css";
import React from "react";
import {yupResolver} from "@hookform/resolvers/yup"
import * as yup from "yup"
import { useNavigate } from "react-router-dom"
import axios from "axios";
import api from "../../services/api";



const validation = yup.object().shape({

  name:yup.string("Nome Obrigatório")
  .min(3, "Nome deve ter no minimo 3 caracteres")
  .required("Nome Obrigatório"),

  surname: yup.string("Sobrenome Obrigatorio")
  .min(3, "Sobrenome deve ter no minimo 3 caracteres"),

  email: yup.string("Necessario Colocar um Email Valido")
  .email("Email fora do padrao normal")
  //.matches(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)
  .required("Necessario preencher o campo login"),

  confirmEmail: yup.string("Necessario Colocar um Email Valido")
  .oneOf([yup.ref("email"), null], "As senhas precisam ser iguais"),
  
  password: yup.string("Necessario preencher o campo senha")
  .required("Necessario preencher o campo senha")
  .min(8, "A senha precisa ter no mínimo 8 caracteres")
   //.matches(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{7,}$/, "Tamanho da senha fora do padrao") 
   //A senha precisa ter no mínimo 8 caracteres, ' +
  // 'uma letra maiúscula e uma letra minúscula, ' +
  // 'um número e um caracter especial'
})


function Createaccount() {

  const { register, handleSubmit, formState: { errors }, } = useForm(
    {
      resolver: yupResolver(validation)
    }
  );

  
  const navigate = useNavigate();

  function newUser( value) {

    console.log(value)
    
    if (value.email !== value.confirmEmail) {
      alert("E-mails diferentes!");
    }else{
      api.post("https://back.viniciusofagundes.com.br/register", {
          firstName: value.name,
          surname: value.surname,
          email: value.email,
          password: value.password
      })
    .then((response) => {
      console.log(response)
      console.log("Deu certo")
      navigate("/login")
    })
    .catch((erro) => {
      console.log(erro)
    })
    }

  }


  return (
    <div className="createAccount">
      <form
        action=""
        className="createaccountBar"
        onSubmit={handleSubmit(newUser)}
      >
        <h1 className="createTitle">Criar Conta</h1>

        <div className="input">
          <input
          className="create"
            type="text"
            name="name"
            placeholder="Nome"
            {...register("name")}
          />
          { <span className="spanError1">{errors.name?.message}</span>}

          <input
          className="create" type="text" name="surname" placeholder="Sobrenome"
            {...register("surname")}
          />
          { <span className="spanError1">{errors.surname?.message}</span>}

          <input
          className="create"
            type="email"
            name="email"
            placeholder="Email"
            {...register("email")}
          />
          { <span className="spanError1"> {errors.email?.message} </span>}

          <input
          className="create"
            type="email"
            name="confirmEmail"
            placeholder="Confirmar Email"
            {...register("confirmEmail")}
          />
          { <span className="spanError1">{errors.confirmEmail?.message}</span>}

          <input
          className="create"
            type="password"
            placeholder="Senha"
            {...register("password")}
          />
          { <span className="spanError1">{errors.password?.message}</span>}
        </div>

        <button type="submit" className="button buttonR">
          Registrar
        </button>

        <div className="log">Já tem uma conta?<a href="/login"> Faça Login</a></div>
      </form>
    </div>
  );
}

export default Createaccount;
